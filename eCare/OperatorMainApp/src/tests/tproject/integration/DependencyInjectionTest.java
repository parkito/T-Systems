package tproject.integration;

import operator.dao.api.AccessLevelDAO;
import operator.dao.api.ContractDAO;
import operator.dao.api.TariffDAO;
import operator.dao.api.UserDAO;
import operator.services.api.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

/**
 * A test of entity manager injection.
 */
@ContextConfiguration(locations = "/spring.xml")
public class DependencyInjectionTest extends AbstractJUnit4SpringContextTests {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserService userService;
    @Autowired
    private TariffService tariffService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AccessLevelService accessLevel;
    @Autowired
    private TariffOptionService optionService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private TariffDAO tariffDAO;
    @Autowired
    private ContractDAO contractDAO;
    @Autowired
    private AccessLevelDAO accessLevelDAO;
    @Autowired
    private TariffDAO optionDAO;


    @Test
    public void testEntityManager() {
        assertNotNull(entityManager);
    }

    @Test
    public void testUserService() {
        assertNotNull(userService);
    }

    @Test
    public void testTariffService() {
        assertNotNull(tariffService);
    }

    @Test
    public void testContractService() {
        assertNotNull(contractService);
    }

    @Test
    public void testRoleService() {
        assertNotNull(accessLevel);
    }

    @Test
    public void testOptionService() {
        assertNotNull(optionService);
    }

    @Test
    public void testUserDAO() {
        assertNotNull(userDAO);
    }

    @Test
    public void testTariffDAO() {
        assertNotNull(tariffDAO);
    }

    @Test
    public void testContractDAO() {
        assertNotNull(contractDAO);
    }

    @Test
    public void testRoleDAO() {
        assertNotNull(accessLevelDAO);
    }

    @Test
    public void testOptionDAO() {
        assertNotNull(optionDAO);
    }
}
