//package tproject.services.implementation;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import ru.tsystems.tproject.entities.Role;
//import ru.tsystems.tproject.services.API.RoleService;
//
//import static org.junit.Assert.*;
//
///**
// * This test checks that there are only 2 roles in the database - admin and user.
// */
//
//@ContextConfiguration(locations = "/spring.xml")
//public class RoleServiceTest extends AbstractJUnit4SpringContextTests {
//
//    @Autowired
//    private RoleService roleService;
//
//    @Test
//    public void testRoleService() {
//        Role user = roleService.getEntityById(1);
//        Role employee = roleService.getEntityById(2);
//        assertTrue(roleService.getAll().size() == 2);
//        assertEquals(user.getName(), "User");
//        assertEquals(employee.getName(), "Employee");
//    }
//}
