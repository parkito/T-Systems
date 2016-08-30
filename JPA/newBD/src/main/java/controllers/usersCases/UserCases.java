package controllers.usersCases;

import entities.User;
import services.api.UserService;
import services.implementation.UserServiceImpl;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/
public class UserCases {
    UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        UserCases userCases = new UserCases();
        System.out.println(userCases.isAuthorized("aa@b.ru", "1234"));
    }

    public boolean isAuthorized(String eMail, String password) {
        try {
            User user = userService.getUserByEMAil(eMail);
            if (user.getPassword().equals(password))
                return true;
            else return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
