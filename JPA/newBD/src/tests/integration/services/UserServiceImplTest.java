package integration.services;

import entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import integration.implementation.UserServiceImpl;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();
    User user0 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "spb", "a@2.ru", "1234");
    User user01 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "msk", "a@2.ru", "1234");
    User user1 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "a@b.ru", "123");
    User user2 = new User("Izmail", "Ivanov", "08.10.1996", "453", "msk", "b@b.ru", "1234");
    User user3 = new User("Petr", "Kozlov", "04.06.1995", "678", "spb", "c@b.ru", "12332");
    User user4 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "d@b.ru", "12343");
    User user5 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "c@b.ru", "12334");
    User user6 = new User("test", "test", "08.10.2000", "123", "spb", "c@c.ru", "12334");


    @Before
    public void before() {
        userService = new UserServiceImpl();
//        if (userService.getUserByEMAil("c@c.ru")==null)
        userService.createEntity(user6);
    }

    @Test//(expected = IllegalArgumentException.class)
    public void createEntitOK() {
        userService.createEntity(user1);
        userService.createEntity(user2);
        userService.createEntity(user3);
        userService.createEntity(user4);
        userService.createEntity(user5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createEntityWrong() throws Exception {
        throw new IllegalArgumentException();
    }

    @Test
    public void getEntityById() throws Exception {
        User user = userService.getEntityById(1);
        Assert.assertEquals(user, user0);
    }

    @Test
    public void updateEntity() throws Exception {
        User user = userService.getEntityById(1);
        user.setAdress("msk");
        userService.updateEntity(user);
        Assert.assertEquals(user.getAdress(), "msk");
    }

    @Test(expected = Exception.class)
    public void deleteEntity() throws Exception {
        System.out.println(user6.getUserId());
        userService.deleteEntity(userService.getEntityById(user6.getUserId()));
        userService.updateEntity(user6);
        userService.getUserByEMAil("c@c.ru");

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void isEntityExists() throws Exception {

    }

    @Test
    public void getUserByNumber() throws Exception {

    }

    @Test
    public void getUserByEMAil() throws Exception {

    }

}