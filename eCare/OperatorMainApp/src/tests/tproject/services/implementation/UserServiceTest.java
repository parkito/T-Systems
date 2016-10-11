//package tproject.services.implementation;
//
//
//import org.junit.Test;
//import org.junit.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.jdbc.JdbcTestUtils;
//import ru.tsystems.tproject.entities.User;
//import ru.tsystems.tproject.exceptions.CustomDAOException;
//import ru.tsystems.tproject.services.API.RoleService;
//import ru.tsystems.tproject.services.API.UserService;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//@ContextConfiguration(locations = "/spring.xml")
//public class UserServiceTest extends AbstractJUnit4SpringContextTests {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    /*for testing in IDEA uncomment the variables below */
//
//    private static final String createScript = "mobile/src/main/resources/sql/create-data-user.sql";
//    private static final String deleteScript = "mobile/src/main/resources/sql/remove-data-user.sql";
//  /*  private static final String createScript = "src/main/resources/sql/create-data-user.sql";
//    private static final String deleteScript = "src/main/resources/sql/remove-data-user.sql";
//*/
//    @Before
//    public void insertData() {
//        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(createScript), false);
//    }
//    @After
//    public void deleteData() {
//        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(deleteScript), false);
//    }
//    //a test to check the "create" method
//    @Test
//    public void testUserCreate() {
//        userService.createEntity(new User("James", "Brown", new Date(), "passport", "address", "email@gmail.com", "1a3bjh9UzwC", 300, "password", roleService.getEntityById(2)));
//        User user = userService.getUserByLogin("1a3bjh9UzwC");
//        assertTrue(user.getRole().getId() == 2);
//        userService.deleteEntity(user);
//    }
//    //a test to check the "read" method
//    @Test
//    public void testUserRead() {
//        User user = userService.getUserByLogin("1poi3JUShN76c");
//        User user2 = userService.getEntityById(user.getId());
//        assertTrue(user.toString().equals(user2.toString()));
//    }
//    //a test to check the "update" method
//    @Test
//    public void testUserUpdate() {
//        User user = userService.getUserByLogin("1poi3JUShN76c");
//        user.setBalance(1398);
//        userService.updateEntity(user);
//        user = userService.getEntityById(user.getId());
//        assertTrue(user.getBalance() == 1398);
//    }
//    //a test to check the "delete" method
//    @Test(expected = CustomDAOException.class)
//    public void testUserDelete() {
//        User user = userService.getUserByLogin("1poi3JUShN76c");
//        userService.deleteEntity(user);
//        userService.getUserByLogin("1poi3JUShN76c");
//    }
//    //a test to check the "getAll" method
//    @Test
//    public void testUserGetAll() {
//        List<User> userList = userService.getAll();
//        assertTrue(userList.size() > 1);
//    }
//    //a test to check the "getUserByLogin" method success
//    @Test
//    public void testGetUserByLoginSuccess() {
//        User user = userService.getUserByLogin("1poi3JUShN76c");
//        assertNotNull(user);
//    }
//    //a test to check the "getUserByLogin" method failure
//    @Test (expected = CustomDAOException.class)
//    public void testGetUserByLoginFail() {
//        userService.getUserByLogin("j6ks8Ynfk4ui");
//    }
//
//
//
//
//
//}
