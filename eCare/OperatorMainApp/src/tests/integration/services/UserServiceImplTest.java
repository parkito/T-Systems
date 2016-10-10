//package services;
//
//import operator.entities.User;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import services.implementation.UserServiceImpl;
//
//import java.util.List;
//
///**
// * Created by Artyom Karnov on 8/27/16.
// * artyom-karnov@yandex.ru
// **/
//public class UserServiceImplTest {
//    UserServiceImpl userService;
//    User user0 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "spb", "a@2.ru", "1234");
//    User user01 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "msk", "a@2.ru", "1234");
//    User user1 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "a@b.ru", "123");
//    User user2 = new User("Izmail", "Ivanov", "08.10.1996", "453", "msk", "b@b.ru", "1234");
//    User user3 = new User("Petr", "Kozlov", "04.06.1995", "678", "spb", "c@b.ru", "12332");
//    User user4 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "d@b.ru", "12343");
//    User user5 = new User("Petr", "Ivanov", "08.10.2000", "123", "spb", "c@b.ru", "12334");
//    User user6 = new User("test", "test", "08.10.2000", "123", "spb", "c@c.ru", "12334");
//
//
//    @Ignore
//    @Before
//    public void before() {
//        userService = new UserServiceImpl();
//
//    }
//
//    @Ignore
//    @Test
//    public void createEntitOK() {
//        userService.createEntity(user1);
//        userService.createEntity(user2);
//        userService.createEntity(user3);
//        userService.createEntity(user4);
//        userService.createEntity(user5);
//    }
//
//    @Ignore
//    @Test(expected = IllegalArgumentException.class)
//    public void createEntityWrong() throws Exception {
//        throw new IllegalArgumentException();
//    }
//
//    @Ignore
//    @Test
//    public void getEntityById() throws Exception {
//        User user = userService.getEntityById(1);
//        Assert.assertEquals(user.getEmail(), user0.getEmail());
//    }
//
//    @Ignore
//    @Test
//    public void updateEntity() throws Exception {
//        User user = userService.getEntityById(1);
//        user.setAdress("msk");
//        userService.updateEntity(user);
//        Assert.assertEquals(user.getAdress(), "msk");
//    }
//
//    @Ignore
//    @Test(expected = IllegalArgumentException.class)
//    public void deleteEntity() {
//        userService.deleteEntity(userService.getEntityById(user6.getUserId()));
//        userService.updateEntity(user6);
//        userService.getUserByEMAil("c@c.ru");
//
//    }
//
//    @Ignore
//    @Test
//    public void getAll() throws Exception {
//        List<User> users = userService.getAll();
//        Assert.assertNotEquals(users, null);
//    }
//
//    @Ignore
//    @Test
//    public void isEntityExists() throws Exception {
//        User user = userService.getEntityById(1);
//        Assert.assertEquals(userService.isUserExists(user), true);
//    }
//
//    @Ignore
//    @Test
//    public void getUserByNumber() throws Exception {
//        User user = userService.getUserByNumber("214189");
//        Assert.assertEquals(user.getEmail(), "e@b.ru");
//    }
//
//    @Ignore
//    @Test
//    public void getUserByEMAil() throws Exception {
//        User user = userService.getUserByEMAil("e@b.ru");
//        Assert.assertEquals(user.getSecondName(), "Ivanov");
//    }
//
//}