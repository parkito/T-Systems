//package com.example.tests;
//
//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class Tariffs {
//    private WebDriver driver;
//    private String baseUrl;
//    private boolean acceptNextAlert = true;
//    private StringBuffer verificationErrors = new StringBuffer();
//
//    @Before
//    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
//        baseUrl = "http://localhost:8080/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testTariffs() throws Exception {
//        driver.get(baseUrl + "/logout");
//        driver.findElement(By.name("password")).clear();
//        driver.findElement(By.name("password")).sendKeys("12346");
//        driver.findElement(By.name("username")).clear();
//        driver.findElement(By.name("username")).sendKeys("c@b.ru");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.linkText("Tariffs")).click();
//        driver.findElement(By.xpath("(//input[@id='optionsRadios0'])[6]")).click();
//        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
//        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S] $"));
//        driver.findElement(By.xpath("//header[@id='cm-header']/nav/div[4]/button")).click();
//        driver.findElement(By.cssSelector("b")).click();
//        driver.findElement(By.id("optionsRadios0")).click();
//        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
//        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S] $"));
//        driver.findElement(By.xpath("//header[@id='cm-header']/nav/div[4]/button")).click();
//        driver.findElement(By.xpath("//div[@id='global']/div[2]/div/div[2]/div/div[2]")).click();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
//}
