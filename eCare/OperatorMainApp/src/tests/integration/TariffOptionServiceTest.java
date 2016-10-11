//package tproject.services.implementation;
//
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.jdbc.JdbcTestUtils;
//import ru.tsystems.tproject.entities.TariffOption;
//import ru.tsystems.tproject.services.API.OptionService;
//import ru.tsystems.tproject.services.API.TariffService;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@ContextConfiguration(locations = "/spring.xml")
//public class TariffOptionServiceTest extends AbstractJUnit4SpringContextTests {
//
//    @Autowired
//    private TariffService tariffService;
//    @Autowired
//    private OptionService optionService;
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    /*for testing in IDEA uncomment the variables below */
//
//    private static final String createScript = "mobile/src/main/resources/SQLTestScripts/create-data-tariff.SQLTestScripts";
//    private static final String deleteScript = "mobile/src/main/resources/SQLTestScripts/remove-data-tariff.SQLTestScripts";
//
// /*   private static final String createScript = "src/main/resources/SQLTestScripts/create-data-tariff.SQLTestScripts";
//    private static final String deleteScript = "src/main/resources/SQLTestScripts/remove-data-tariff.SQLTestScripts";
//*/
//    @Before
//    public void insertData() {
//        //noinspection deprecation
//        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(createScript), false);
//    }
//    @After
//    public void deleteData() {
//        //noinspection deprecation
//        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(deleteScript), false);
//    }
//
//
//    //a test to check the "create" method
//    @Test
//    public void testTariffCreate() {
//        int a = tariffService.getAll().size();
//        TariffOption tariffOption = new TariffOption("testTariff3", 1234);
//        tariffService.createEntity(tariffOption);
//        int b = tariffService.getAll().size();
//        assertTrue(a == b - 1);
//        tariffService.deleteEntity(tariffOption);
//    }
//    //a test to check the "read" method
//    @Test
//    public void testTariffRead() {
//        TariffOption tariffOption = tariffService.getEntityById(211369877);
//        assertEquals(tariffOption.getName(), "testTariff1");
//    }
//    //a test to check the "update" method
//
//    @Test
//    public void testTariffUpdate() {
//        TariffOption tariffOption = tariffService.getEntityById(211369877);
//        assertTrue(tariffOption.getPossibleOptions().isEmpty());
//        tariffOption.setPrice(89765);
//        tariffOption.getPossibleOptions().add(optionService.getEntityById(214561786));
//        tariffService.updateEntity(tariffOption);
//        tariffOption = tariffService.getEntityById(211369877);
//        assertFalse(tariffOption.getPossibleOptions().isEmpty());
//        // a test of getAllOptionsForTariff
//        assertTrue(tariffOption.getPossibleOptions().size() == optionService.getAllOptionsForTariff(tariffOption.getId()).size());
//        assertTrue(tariffOption.getPrice() == 89765);
//        tariffOption.removePossibleOptions();
//        tariffService.updateEntity(tariffOption);
//
//    }
//    //a test to check the "delete" method
//    @Test//expected = CustomDAOException.class)
//    public void testTariffDelete() {
//        TariffOption tariffOption = tariffService.getEntityById(211369877);
//        tariffService.deleteEntity(tariffOption);
//        assertNull(tariffService.getEntityById(211369877));
//    }
//    //a test to check the "getAll" method
//    @Test
//    public void testTariffGetAll() {
//        List<TariffOption> tariffOptionList = tariffService.getAll();
//        assertTrue(tariffOptionList.size() > 1);
//    }
//
//
//
//
//
//
//}
