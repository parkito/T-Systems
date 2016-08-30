package controllers;

import entities.AccessLevel;
import entities.Tariff;
import entities.User;
import services.api.AccessLevelService;
import services.api.TariffService;
import services.implementation.AccessLevelImpl;
import services.implementation.TariffServiceImpl;
import services.implementation.UserServiceImpl;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 8/30/16  add tarrifs
// TODO: 8/30/16 add tariffOption
// TODO: 8/30/16 add contract
// TODO: 8/30/16 work with tariff option
public class First {
    public static void main(String[] args) {
        //1) add roles for users
//        AccessLevelService levelService = new AccessLevelImpl();
//        AccessLevel accessLevel = new AccessLevel("userAvailable");
//        AccessLevel accessLevel1 = new AccessLevel("userBanned");
//        AccessLevel accessLevel2 = new AccessLevel("Manager");
//        levelService.createEntity(accessLevel);
//        levelService.createEntity(accessLevel1);
//        levelService.createEntity(accessLevel2);


        //2) add users
//        User user0 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "spb", "a@b.ru", "1234");
//        User user1 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "spb", "a@b.ru", "1234");
//        User user2 = new User("Ivan", "Petrov", "05.05.1995", "pass2", "nn", "b@b.ru", "12345");
//        User user3 = new User("Ivan", "Kirillov", "12.11.1950", "pass3", "dzr", "c@b.ru", "12346");
//        User user4 = new User("Artem", "Ivanov", "07.10.1990", "pass4", "msk", "d@b.ru", "12347");
//        User user5 = new User("Kirill", "Ivanov", "18.11.1999", "pass5", "ny", "e@b.ru", "12348");
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createEntity(user1);
//        userService.createEntity(user2);
//        userService.createEntity(user3);
//        userService.createEntity(user4);
//        userService.createEntity(user5);

        //3) add Tariffs
//        Tariff tariff1 = new Tariff("base", 50.0, 100.0);
//        Tariff tariff2 = new Tariff("gb1", 50.0, 50.0);
//        Tariff tariff3 = new Tariff("gb2", 100.0, 150.0);
//        Tariff tariff4 = new Tariff("call1", 50.0, 100.0);
//        Tariff tariff5 = new Tariff("call2", 150.0, 50.0);
//        Tariff tariff6 = new Tariff("unlim", 200.0, 200.0);
//        TariffServiceImpl tariffService = new TariffServiceImpl();
//        tariffService.createEntity(tariff1);
//        tariffService.createEntity(tariff2);
//        tariffService.createEntity(tariff3);
//        tariffService.createEntity(tariff4);
//        tariffService.createEntity(tariff5);
//        tariffService.createEntity(tariff6);


    }
}