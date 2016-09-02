package controllers.usersCases;

import entities.Contract;
import entities.TariffOption;
import entities.User;
import exceptions.UserNotFoundException;
import services.api.AccessLevelService;
import services.api.UserService;
import services.implementation.AccessLevelImpl;
import services.implementation.ContractServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/
public class UserCases {
    UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        UserCases userCases = new UserCases();
        UserServiceImpl userService = new UserServiceImpl();
        userCases.makeUserManager(userService.getUserByEMAil("b@b.ru"));
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
}
