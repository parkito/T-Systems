//package tproject.services.implementation;
//
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.jdbc.JdbcTestUtils;
//import org.springframework.transaction.annotation.Transactional;
//import ru.tsystems.tproject.entities.Option;
//import ru.tsystems.tproject.services.API.OptionService;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@SuppressWarnings("deprecation")
//@ContextConfiguration(locations = "/spring.xml")
//public class OptionServiceTest extends AbstractJUnit4SpringContextTests {
//
//    @Autowired
//    private OptionService optionService;
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    /*for testing in IDEA uncomment the variables below */
//
//    private static final String createScript = "mobile/src/main/resources/SQLTestScripts/create-data-option.SQLTestScripts";
//    private static final String deleteScript = "mobile/src/main/resources/SQLTestScripts/remove-data-option.SQLTestScripts";
///*
//
//    private static final String createScript = "src/main/resources/SQLTestScripts/create-data-option.SQLTestScripts";
//    private static final String deleteScript = "src/main/resources/SQLTestScripts/remove-data-option.SQLTestScripts";
//*/
//
//    @Before
//    public void insertData() {
//
//        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(createScript), false);
//    }
//    @After
//    public void deleteData() {
//
//        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(deleteScript), false);
//    }
//
//
//    //a test to check the "create" method
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testOptionCreate() {
//        int a = optionService.getAll().size();
//        Option option = new Option("testOption5", 200, 100);
//        optionService.createEntity(option);
//        int b = optionService.getAll().size();
//        assertTrue(b == a + 1);
//        optionService.deleteEntity(option);
//    }
//    //a test to check the "read" method
//    @Test
//    public void testOptionRead() {
//        Option option = optionService.getEntityById(214561783);
//        assertEquals(option.getName(), "testOption1");
//    }
//    //a test to check the "update" method
//    @Test
//    public void testOptionUpdate() {
//        Option option = optionService.getEntityById(214561783);
//        assertTrue(option.getOptionsTogether().isEmpty());
//        assertTrue(option.getOptionsIncompatible().isEmpty());
//        option.setInitialPrice(14041992);
//        option.addOptionsTogether(optionService.getEntityById(214561784));
//        option.addOptionsIncompatible(optionService.getEntityById(214561785));
//        optionService.updateEntity(option);
//        option = optionService.getEntityById(option.getId());
//        assertTrue(option.getInitialPrice() == 14041992);
//        //a test to check the correct work of options together and options incompatible
//        assertTrue(option.getOptionsTogether().size() == optionService.getAllOptionsTogetherForOption(option.getId()).size());
//        assertTrue(option.getOptionsIncompatible().size() == optionService.getAllOptionsIncompatibleForOption(option.getId()).size());
//        option.getOptionsTogether().clear();
//        option.getOptionsIncompatible().clear();
//        optionService.updateEntity(option);
//    }
//    //a test to check the "delete" method
//    @Test//(expected = CustomDAOException.class)
//    public void testOptionDelete() {
//        Option option = optionService.getEntityById(214561783);
//        optionService.deleteEntity(option);
//        assertNull(optionService.getEntityById(214561783));
//    }
//    //a test to check the "getAll" method
//    @Test
//    public void testOptionGetAll() {
//        List<Option> optionsList = optionService.getAll();
//        assertTrue(optionsList.size() > 3);
//    }
//
//
//
//
//
//
//}
