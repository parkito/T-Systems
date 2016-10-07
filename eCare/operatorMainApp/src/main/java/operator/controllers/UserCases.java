package operator.controllers;


import operator.entities.Contract;
import operator.entities.TariffOption;
import operator.entities.User;
import operator.services.api.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Business logic for users
 */
public class UserCases {
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

    // TODO: 10/4/16 Подумать с деланием менеджера
//    /**
//     * User become manager
//     *
//     * @param user entity for changing
//     */
//    public boolean makeUserManager(User user) {
//        try {
//            userService.cahngeUserAccessLevel(user, accessLevelService.getEntityById(3));
//        } catch (CustomDAOException ex) {
//            return false;
//        }
//        return true;
//    }

    /**
     * Getting user name from contract
     *
     * @param contract entity for getting info
     * @return user name
     */
    public String getUserName(Contract contract) {
        return contract.getUser().getName();

    }

    /**
     * Checking manager status
     *
     * @param eMail
     * @return true - user manager, false - if not
     */
    public boolean isManager(String eMail) {
        return userService.getUserByEMAil(eMail).getAccessLevel() != null ? true : false;
    }

    /**
     * Getting user name by email
     *
     * @param eMail entity for getting
     * @return user name
     */
    public String getUserNameByEmail(String eMail) {
        return userService.getUserByEMAil(eMail).getName();
    }

    /**
     * Getting contract list for adjusted user
     *
     * @param eMail entity for getting
     * @return contract list for adjusted user
     */
    public List<Contract> getAllContractsForUser(String eMail) {
        userService.updateEntity(userService.getUserByEMAil(eMail));
        return contractService.getAllContractsForUser(userService.getUserByEMAil(eMail).getUserId());

    }

    public double getPaymentInfo(User user) {
        double payment = 0;
        for (Contract contract : user.getContracts()) {
            for (TariffOption tariffOption : contract.getTariffOptions()) {
                payment += tariffOption.getPrice();
            }
            payment += contract.getTariff().getPrice();
        }
        return payment;
    }
}