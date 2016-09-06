package controllers;

import exceptions.UserNotFoundException;
import services.implementation.UserServiceImpl;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/
public class ManagerCases {
    private UserServiceImpl userService = new UserServiceImpl();

    public boolean isUserExists(String eMail) {
        try {
            System.out.println(userService.getUserByEMAil(eMail).getEmail());
        } catch (UserNotFoundException ex) {
            return false;
        }
        return true;
    }
}
