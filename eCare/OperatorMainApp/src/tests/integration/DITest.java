package integration;

import operator.controllers.ManagerCases;
import operator.controllers.UserCases;
import operator.dao.api.AccessLevelDAO;
import operator.dao.api.ContractDAO;
import operator.dao.api.TariffDAO;
import operator.dao.api.UserDAO;
import operator.services.api.*;
import operator.utils.SearchResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

/**
 * DI tests
 */
@ContextConfiguration(locations = "/spring.xml")
public class DITest extends AbstractJUnit4SpringContextTests {

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
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    ManagerCases managerCases;
    @Autowired
    UserCases userCases;
    @Autowired
    SearchResult searchResult;


    @Test
    public void EntityManagerTest() {
        assertNotNull(entityManager);
    }

    @Test
    public void UserServiceTest() {
        assertNotNull(userService);
    }

    @Test
    public void TariffServiceTest() {
        assertNotNull(tariffService);
    }

    @Test
    public void ContractServiceTest() {
        assertNotNull(contractService);
    }

    @Test
    public void RoleServiceTest() {
        assertNotNull(accessLevel);
    }

    @Test
    public void OptionServiceTest() {
        assertNotNull(optionService);
    }

    @Test
    public void UserDAOTest() {
        assertNotNull(userDAO);
    }

    @Test
    public void TariffDAOTest() {
        assertNotNull(tariffDAO);
    }

    @Test
    public void ContractDAOTest() {
        assertNotNull(contractDAO);
    }

    @Test
    public void RoleDAOTest() {
        assertNotNull(accessLevelDAO);
    }

    @Test
    public void OptionDAOTest() {
        assertNotNull(optionDAO);
    }

    @Test
    public void ManagerCasesTest() {
        assertNotNull(managerCases);
    }

    @Test
    public void UserCasesTest() {
        assertNotNull(managerCases);
    }

    @Test
    public void SearchingUtilityTest() {
        assertNotNull(searchResult);
    }
}
