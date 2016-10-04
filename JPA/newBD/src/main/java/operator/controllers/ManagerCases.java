package operator.controllers;

import operator.entities.*;
import operator.exceptions.ContractNotFoundException;
import operator.exceptions.UserNotFoundException;
import operator.services.api.*;
import operator.utils.Converter;
import operator.utils.EmailSender;
import operator.utils.Smsc;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Business logic for managers
 */
@Service("ManagerCases")
public class ManagerCases {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;
    @Autowired
    TariffService tariffService;
    @Autowired
    TariffOptionService tariffOptionService;
    @Autowired
    AccessLevelService accessLevelService;

    private final static Logger logger = Logger.getLogger(ManagerCases.class);

    /**
     * Checking user existing
     *
     * @param eMail entity for checking
     * @return true - if exists, false - if doesn't
     */
    public boolean isUserExists(String eMail) {
        try {
            userService.getUserByEMAil(eMail).getEmail();
        } catch (UserNotFoundException ex) {
            logger.info(ex);
            return false;
        }
        return true;
    }

    /**
     * Creating user entity and saving it to base
     *
     * @param name         name for user
     * @param secondName   second name for user
     * @param birthdayData birthday for user
     * @param passport     passport for user
     * @param adress       address for user
     * @param email        email for user
     * @param password     password for user
     */
    public void addUserToBase(String name, String secondName, String birthdayData,
                              String passport, String adress,
                              String email, String password) {
        AccessLevel accessLevel = accessLevelService.getEntityById(1);
        User user = new User(name, secondName, birthdayData,
                passport, adress,
                email, password, accessLevel);
        userService.createEntity(user);
    }

    /**
     * Checking number existing
     *
     * @param number entity for checking
     * @return true - if exists, false - if doesn't
     */
    public boolean isNumberExists(String number) {
        try {
            contractService.getContractByNumber(number);
        } catch (ContractNotFoundException ex) {
            logger.info(ex);
            return false;
        }
        return true;
    }

    /**
     * Checking tariff existing
     *
     * @param title entity for checking
     * @return true - if exists, false - if doesn't
     */
    public boolean isTariffExists(String title) {
        for (Tariff tariff : tariffService.getAll()) {
            if (tariff.getTitle().equals(title))
                return true;
        }
        return false;
    }

    /**
     * Creating tariff entity and saving it to base
     *
     * @param title tariff title for adding
     * @param price tariff price for adding
     */
    public void addTariffToBase(String title, String price) {
        Tariff tariff = new Tariff(title, Double.parseDouble(price));
        tariffService.createEntity(tariff);
    }

    /**
     * Creating contract entity and saving it to base
     *
     * @param eMail  contract email for adding
     * @param number contract number for adding
     */
    public void addContractToBase(String eMail, String number) {
        Contract contract = new Contract(number, userService.getUserByEMAil(eMail),
                tariffService.getTariffByTitle("base"));
        contractService.createEntity(contract);
    }

    /**
     * Checking number existing
     *
     * @param title title option for checking
     * @return true - if exists, false - if doesn't
     */
    public boolean isOptionExists(String title) {
        for (TariffOption tariffOption : tariffOptionService.getAll()) {
            if (tariffOption.getTitle().equals(title))
                return true;
        }
        return false;
    }

    /**
     * Creating tariff option entity and saving it to base
     *
     * @param title           option title for adding
     * @param price           option price for adding
     * @param connectionPrice option connection price for adding
     */
    public void addOptionToBase(String title, String price, String connectionPrice) {
        TariffOption tariffOption = new TariffOption(title, Double.parseDouble(price),
                Double.parseDouble(connectionPrice));
        tariffOptionService.createEntity(tariffOption);
    }

    /**
     * Generate password for user
     *
     * @param size password length
     * @return n-length password
     */
    public String passwordGenerator(int size, String number, String eMail, String user) {
        Random rand = new Random();
        int num;
        StringBuilder sb = new StringBuilder();
        String set = "abcdefjhijklmnoprstuqwzxyz0123456789!@#$%^&*()";
        for (int i = 0; i < size; i++) {
            num = rand.nextInt(set.length() - 1);
            sb.append(set.charAt(num));
        }
        String result = sb.toString();
        Smsc sms = new Smsc("parkito", "214189");
//        sms.send_sms(number, "Your password " + result, 1, "", "", 0, "", "");
        EmailSender.send(eMail, user, result);
        try {
            result = Converter.getMD5(result);
        } catch (NoSuchAlgorithmException ex) {
            logger.info(ex);

        }
        return result;
    }


    /**
     * Adding joint tariffs and saving to base
     *
     * @param tariffOne first tariff for adding
     * @param tarifftwo second tariff for adding
     */
    public void addJoinOptionToBase(String tariffOne, String tarifftwo) {
        TariffOption one = null, two = null;
        for (TariffOption tariffOption : tariffOptionService.getAll()) {
            if (tariffOption.getTitle().equals(tariffOne))
                one = tariffOption;
            if (tariffOption.getTitle().equals(tarifftwo))
                two = tariffOption;
        }
        one.addjointTogether(two);
        two.addjointTogether(one);
        tariffOptionService.updateEntity(one);
        tariffOptionService.updateEntity(two);
    }

    /**
     * Adding impossible tariffs and saving to base
     *
     * @param tariffOne first tariff for adding
     * @param tarifftwo second tariff for adding
     */
    public void addImmposibleOptionToBase(String tariffOne, String tarifftwo) {
        TariffOption one = null, two = null;
        for (TariffOption tariffOption : tariffOptionService.getAll()) {
            if (tariffOption.getTitle().equals(tariffOne))
                one = tariffOption;
            if (tariffOption.getTitle().equals(tarifftwo))
                two = tariffOption;
        }
        one.addOptionsIncompatible(two);
        two.addOptionsIncompatible(one);
        tariffOptionService.updateEntity(one);
        tariffOptionService.updateEntity(two);
    }

    public void removeTariff(Tariff tariffForRemoving) {
        boolean contractWasChange = false;
        List<User> users = userService.getAll();
        Tariff tariff = tariffService.getTariffByTitle("base");
        for (Contract contract : contractService.getAll()) {
            if (contract.getTariff().equals(tariffForRemoving)) {
                contract.setTariff(tariff);
                contractWasChange = true;
            }
            if (contractWasChange) {
                contractService.updateEntity(contract);
            }
            contractWasChange = false;
        }
        tariffService.deleteEntity(tariffForRemoving);
    }

    // TODO: 10/4/16 fucking shit works, but throws nullpointerexception
    public void removeTariffOption(TariffOption tariffOptionForRemoving) {
        boolean contractWasChanged = false;
        Object object = new Object();
        synchronized (object) {
            for (Contract contract : contractService.getAll()) {
                for (TariffOption tariffOption : contract.getTariffOptions()) {
                    if (tariffOption.equals(tariffOptionForRemoving)) {
                        contract.getTariffOptions().remove(tariffOption);
                        contractWasChanged = true;
                        break;
                    }
                }
                if (contractWasChanged) {
                    contractService.updateEntity(contract);
                }
                contractWasChanged = false;
            }
        }

        tariffOptionService.deleteEntity(tariffOptionForRemoving);
    }
}
