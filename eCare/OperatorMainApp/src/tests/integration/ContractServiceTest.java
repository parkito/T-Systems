package tproject.services.implementation;


import operator.entities.Contract;
import operator.services.api.ContractService;
import operator.services.api.TariffService;
import operator.services.api.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("deprecation")
@ContextConfiguration(locations = "/spring.xml")
public class ContractServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ContractService contractService;
    @Autowired
    private UserService userService;
    @Autowired
    private TariffService tariffService;
    @Autowired
    private TariffService optionService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*for testing in IDEA uncomment the variables below */

    private static final String createScript = "src/main/resources/SQLTestScripts/operator_Contract.sql";

    @Test
    @Transactional
    @Rollback(true)
    public void testContractCreate() {
        int a = contractService.getAll().size();
        int b = 0;
        Contract contract = new Contract("1212",
                userService.getUserByEMAil("c@b.ru"), tariffService.getTariffByTitle("base"));
        if (!contractService.getContractByNumber("1212").equals(contract)) {
            contractService.createEntity(contract);
            b = contractService.getAll().size();
            assertTrue(b == a + 1);
        } else {
            assertFalse(b == a + 1);
        }
    }
}