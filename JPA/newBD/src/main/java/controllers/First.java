package controllers;

import dao.api.GenericDAO;
import dao.api.UserDAO;
import dao.implementation.GenericDAOImpl;
import dao.implementation.TariffDAOImpl;
import dao.implementation.UserDAOImpl;
import entities.User;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class First {
    public static void main(String[] args) {
        GenericDAOImpl<User, User> genericDAO = new GenericDAOImpl<User,User>();
        User user = new User("Ivan", "Ivanov", "08.10.2000", "123", "spb", "a@b.ru", "123");
        System.out.println(user);
        genericDAO.create(user);
    }
}
