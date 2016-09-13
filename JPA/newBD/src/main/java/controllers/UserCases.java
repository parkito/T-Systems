package controllers;


import entities.Contract;
import entities.User;
import exceptions.CustomDAOException;
import exceptions.UserNotFoundException;
import services.implementation.AccessLevelImpl;
import services.implementation.ContractServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Business logic for users
 */
public class UserCases {
    private UserServiceImpl userService = new UserServiceImpl();
    private AccessLevelImpl accessLevelService = new AccessLevelImpl();
    private ContractServiceImpl contractService = new ContractServiceImpl();

    /**
     * User become manager
     * @param user entity for changing
     */
    public boolean makeUserManager(User user) {
        try {
            userService.cahngeUserAccessLevel(user, accessLevelService.getEntityById(3));
        } catch (CustomDAOException ex) {
            return false;
        }
        return true;
    }

    /**
     * Getting user name from contract
     * @param contract entity for getting info
     * @return user name
     */
    public String getUserName(Contract contract) {
            return contract.getUser().getName();

    }

    /**
     * Checking manager status
     * @param eMail
     * @return true - user manager, false - if not
     */
    public boolean isManager(String eMail) {
        return userService.getUserByEMAil(eMail).getAccessLevel() != null ? true : false;
    }

    /**
     * Getting user name by email
     * @param eMail entity for getting
     * @return user name
     */
    public String getUserNameByEmail(String eMail) {
        return userService.getUserByEMAil(eMail).getName();
    }

    /**
     * Getting contract list for adjusted user
     * @param eMail entity for getting
     * @return contract list for adjusted user
     */
    public List<Contract> getAllContractsForUser(String eMail) {
        userService.updateEntity(userService.getUserByEMAil(eMail));
        return contractService.getAllContractsForUser(userService.getUserByEMAil(eMail).getUserId());

    }
}