package unit.controllers;

import operator.controllers.ManagerCases;
import operator.exceptions.CustomDAOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Artyom Karnov on 9/12/16.
 * artyom-karnov@yandex.ru
 **/
public class ManagerCasesTest {
    @InjectMocks
    ManagerCases managerCasesMock = new ManagerCases();

    @Before
    public void beforeTest() {
        when(managerCasesMock.isUserExists("c@b.ru")).thenReturn(true);
        doThrow(new CustomDAOException("User already exists"))
                .when(managerCasesMock).addUserToBase("art", "kar", "08.02.1995",
                "pass", "addr", "c@c.ru", "pass");
        when(managerCasesMock.isNumberExists("214189")).thenReturn(true);
        when(managerCasesMock.isTariffExists("call1")).thenReturn(true);
        doThrow(new CustomDAOException("Tariff already exists"))
                .when(managerCasesMock).addContractToBase("base", "100.0");
        doThrow(new CustomDAOException("Contract already exists"))
                .when(managerCasesMock).addTariffToBase("c@b.ru", "214189");
        when(managerCasesMock.isOptionExists("base")).thenReturn(true);
        doThrow(new CustomDAOException("Contract already exists"))
                .when(managerCasesMock).addOptionToBase("new", "100", "100");
        when(managerCasesMock.passwordGenerator(5, "214189", "c@b.ru", "user")).thenReturn("password");
        when(managerCasesMock.isUserExists("b@b.ru")).thenReturn(true);

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
}