package services;

import entities.User;
import org.junit.Before;
import org.junit.Test;

import services.implementation.UserServiceImpl;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class UserServiceImplTest {
    User user1 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "a@b.ru", "123");
    User user2 = new User("Izmail", "Ivanov", "08.10.1996", "453", "msk", "b@b.ru", "1234");
    User user3 = new User("Petr", "Kozlov", "04.06.1995", "678", "spb", "c@b.ru", "12332");
    User user4 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "d@b.ru", "12343");
    User user5 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "c@b.ru", "12334");

    UserServiceImpl userService;

    @Before
    public void before() {
        userService = new UserServiceImpl();
    }


    @Test
    public void createEntitOK() {
        userService.createEntity(user1);
        userService.createEntity(user2);
        userService.createEntity(user3);
        userService.createEntity(user4);
    }

    @Test(expected = Exception.class)
    public void createEntityWrong() throws Exception {
        userService.createEntity(user5);

    }

    @Test
    public void getEntityById() throws Exception {

    }

    @Test
    public void updateEntity() throws Exception {

    }

    @Test
    public void deleteEntity() throws Exception {

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