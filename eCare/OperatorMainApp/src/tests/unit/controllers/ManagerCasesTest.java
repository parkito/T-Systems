package unit.controllers;

import controllers.ManagerCases;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Created by Artyom Karnov on 9/12/16.
 * artyom-karnov@yandex.ru
 **/
public class ManagerCasesTest {
    ManagerCases managerCasesMock;

    @Before
    public void beforeTest() {
        managerCasesMock = Mockito.mock(ManagerCases.class);
        when(managerCasesMock.isNumberExists("214189")).thenReturn(true);
        when(managerCasesMock.isOptionExists("base")).thenReturn(true);
        when(managerCasesMock.isTariffExists("call1")).thenReturn(true);
        when(managerCasesMock.isUserExists("b@b.ru")).thenReturn(true);
        when(managerCasesMock.passwordGenerator(5)).thenReturn("j4j5j");

    }

    @Test
    public void isUserExists() {
        Assert.assertEquals(managerCasesMock.isUserExists("b@b.ru"), true);
    }

    @Test
    public void isUserExistsOne() {
        Assert.assertEquals(managerCasesMock.isUserExists("cc@b.ru"), false);
    }

    @Test
    public void isNumberExists() {
        Assert.assertEquals(managerCasesMock.isNumberExists("214189"), true);
    }

    @Test
    public void isNumberExistsOne() {
        Assert.assertEquals(managerCasesMock.isNumberExists("21441889"), false);
    }

    @Test
    public void isTariffExists() {
        Assert.assertEquals(managerCasesMock.isTariffExists("call1"), true);
    }

    @Test
    public void isTariffExistsOne() {
        Assert.assertEquals(managerCasesMock.isTariffExists("call11"), false);
    }

    @Test
    public void isOptionExists() {
        Assert.assertEquals(managerCasesMock.isOptionExists("base"), true);
    }

    @Test
    public void isOptionExistsOne() {
        Assert.assertEquals(managerCasesMock.isOptionExists("baseff"), false);
    }


    @Test
    public void passwordGenerator() {
        Assert.assertEquals(managerCasesMock.passwordGenerator(5).length(), 5);
    }


}