package operator.controllers;


import operator.entities.AccessLevel;
import operator.entities.Contract;
import operator.entities.TariffOption;
import operator.entities.User;
import operator.exceptions.CustomDAOException;
import operator.services.api.AccessLevelService;
import operator.services.api.ContractService;
import operator.services.api.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Business logic for users
 */
@Service("UserCases")
public class UserCases {
    @Autowired
    private UserService usersService;
    @Autowired
    private ContractService service;
    @Autowired
    private AccessLevelService accessLevelsService;

    private final static Logger logger = Logger.getLogger(ManagerCases.class);

    // TODO: 10/4/16 Подумать с деланием менеджера

    /**
     * User become manager
     *
     * @param user entity for changing
     * @return true - if level changed, false if something went wrong
     */
    public boolean makeUserManager(User user) {
        try {
            AccessLevel accessLevelManger = accessLevelsService.getEntityById(3);
            user.setAccessLevel(accessLevelManger);
            usersService.updateEntity(user);
        } catch (CustomDAOException ex) {
            return false;
        }
        return true;
    }

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
        return usersService.getUserByEMAil(eMail).getAccessLevel() != null ? true : false;
    }

    /**
     * Getting user name by email
     *
     * @param eMail entity for getting
     * @return user name
     */
    public String getUserNameByEmail(String eMail) {
        return usersService.getUserByEMAil(eMail).getName();
    }

    /**
     * Getting contract list for adjusted user
     *
     * @param eMail entity for getting
     * @return contract list for adjusted user
     */
    public List<Contract> getAllContractsForUser(String eMail) {
        usersService.updateEntity(usersService.getUserByEMAil(eMail));
        return service.getAllContractsForUser(usersService.getUserByEMAil(eMail).getUserId());

    }

    public double getPaymentInfo(User user) {
        double payment = 0;
        for (Contract contract : user.getContracts()) {
            if (!contract.getIsBlocked()) {
                for (TariffOption tariffOption : contract.getTariffOptions()) {
                    payment += tariffOption.getPrice();
                }
            }
            payment += contract.getTariff().getPrice();
        }
        return payment;
    }
}