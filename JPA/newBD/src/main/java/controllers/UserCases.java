package controllers;


import entities.Contract;
import entities.User;
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
public class UserCases {
    private UserServiceImpl userService = new UserServiceImpl();
    private AccessLevelImpl accessLevelService = new AccessLevelImpl();
    private ContractServiceImpl contractService = new ContractServiceImpl();

    /**
     *
     * @param user
     */
    public void makeUserManager(User user) {
        userService.cahngeUserAccessLevel(user, accessLevelService.getEntityById(3));
    }

    /**
     *
     * @param contract
     * @return
     */
    public String getUserName(Contract contract) {
        return contract.getUser().getName();

    }

    /**
     *
     * @param eMail
     * @return
     */
    public boolean isManager(String eMail) {
        return userService.getUserByEMAil(eMail).getAccessLevel() != null ? true : false;
    }

    /**
     *
     * @param eMail
     * @return
     */
    public String getUserNameByEmail(String eMail) {
        return userService.getUserByEMAil(eMail).getName();
    }

    /**
     *
     * @param eMail
     * @return
     */
    public List<Contract> getAllContractsForUser(String eMail) {
        userService.updateEntity(userService.getUserByEMAil(eMail));
        return contractService.getAllContractsForUser(userService.getUserByEMAil(eMail).getUserId());

    }


}