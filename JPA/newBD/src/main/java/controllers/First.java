package controllers;

import dao.api.GenericDAO;
import dao.api.UserDAO;
import dao.implementation.GenericDAOImpl;
import dao.implementation.TariffDAOImpl;
import dao.implementation.UserDAOImpl;
import entities.User;
import exceptions.UserNotFoundException;
import services.implementation.UserServiceImpl;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class First {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil("c@b.ru");
        User user2 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "c@b.ru", "123");
//        userService.createEntity(user2);
        System.out.println(userService.isEntityExists(user));
        System.out.println(user);

    }
}