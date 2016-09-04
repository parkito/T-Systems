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
    private User user;
    private AccessLevelImpl accessLevelService = new AccessLevelImpl();
    private ContractServiceImpl contractService = new ContractServiceImpl();
    Cookie[] cookies;


    public void main(String[] args) {

    }


    public boolean isAuthorized(String eMail, String password) {
        try {
            user = userService.getUserByEMAil(eMail);
            if (user.getPassword().equals(password))
                return true;
            else return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        } catch (UserNotFoundException ex) {
            return false;
        }
    }

    public void makeUserManager(User user) {
        userService.cahngeUserAccessLevel(user, accessLevelService.getEntityById(3));
    }

    public String getUserName(HttpServletRequest req) {
        String eMail = "";
        cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("eMail")) eMail = cookie.getValue();
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);
        return user.getName();

    }

    // TODO: 9/4/16 Optimize if it possible
    public boolean isManager(String eMail) {
        return userService.getUserByEMAil(eMail).getAccessLevel() != null ? true : false;
    }

    public String getCookiesValue(HttpServletRequest req, String value) {
        cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(value))
                return cookie.getValue();
        }
        return "";
    }

    public String getUserNameByEmail(String eMail) {
        return userService.getUserByEMAil(eMail).getName();
    }

    public List<Contract> getAllContractsForUser(String eMail) {
        return contractService.getAllContractsForUser(userService.getUserByEMAil(eMail).getUserId());


    }


}
