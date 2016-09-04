package controllers.usersCases;

import entities.Contract;
import entities.TariffOption;
import entities.User;
import exceptions.OptionsForEntityNotGotException;
import exceptions.UserNotFoundException;
import services.api.AccessLevelService;
import services.api.UserService;
import services.implementation.AccessLevelImpl;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.UserServiceImpl;

import javax.persistence.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/
public class UserCases {
    UserService userService = new UserServiceImpl();

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("operator");
    protected EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

    }


    public boolean isAuthorized(String eMail, String password) {
        try {
            User user = userService.getUserByEMAil(eMail);
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
        AccessLevelService accessLevelService = new AccessLevelImpl();
        UserServiceImpl userService = new UserServiceImpl();
        userService.cahngeUserAccessLevel(user, accessLevelService.getEntityById(3));
    }

    static public String getUserName(HttpServletRequest req) {
        String eMail = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("eMail")) eMail = cookie.getValue();
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);
        return user.getName();

    }

    static public boolean isManager(String eMail) {
        UserServiceImpl userService = new UserServiceImpl();
        return userService.getUserByEMAil(eMail).getAccessLevel().getStatus().equals("Manager") ? true : false;
    }

    public static String getCookiesValue(HttpServletRequest req, String value) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(value))
                return cookie.getValue();
        }
        return "";
    }


}
