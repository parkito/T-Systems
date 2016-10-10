package unit.controllers;

import operator.controllers.UserCases;
import operator.entities.AccessLevel;
import operator.entities.Contract;
import operator.entities.User;
import operator.exceptions.CustomDAOException;
import operator.services.implementation.ContractServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Artyom Karnov on 9/12/16.
 * artyom-karnov@yandex.ru
 **/
public class UserCasesTest {
    @Mock
    UserCases userCasesMock;
    Contract contractMock;
    CustomDAOException customDAOException;
    ContractServiceImpl contractService;
    Contract contract;
    List<Contract> contractList;

    User user0 = new User("Ivan", "Ivanov", "08.10.1990", "pass1",
            "spb", "a@2.ru", "1234", new AccessLevel());
    User user01 = new User("Ivan", "Ivanov", "08.10.1990", "pass1",
            "msk", "a@2.ru", "1234", new AccessLevel());
    User user1 = new User("Petr", "Ivanov", "08.10.2000", "123",
            "spb", "a@b.ru", "123", new AccessLevel());
    User user2 = new User("Izmail", "Ivanov", "08.10.1996", "453",
            "msk", "b@b.ru", "1234", new AccessLevel());
    User user3 = new User("Petr", "Kozlov", "04.06.1995", "678",
            "spb", "c@b.ru", "12332", new AccessLevel());
    User user4 = new User("Petr", "Ivanov", "08.10.2000", "123",
            "spb", "d@b.ru", "12343", new AccessLevel());
    User user5 = new User("Petr", "Ivanov", "08.10.2000", "123",
            "spb", "c@b.ru", "12334", new AccessLevel());
    User user6 = new User("test", "test", "08.10.2000", "123",
            "spb", "c@c.ru", "12334", new AccessLevel());

    @Before
    public void beforeTest() {
        contractList = new ArrayList<>();
        customDAOException = new CustomDAOException("error");
        userCasesMock = Mockito.mock(UserCases.class);
        contractMock = Mockito.mock(Contract.class);
        when(userCasesMock.isManager("b@b.ru")).thenReturn(true);
        when(userCasesMock.isManager("a@2.ru")).thenReturn(false);
        when(userCasesMock.makeUserManager(user2)).thenThrow(customDAOException);
        when(userCasesMock.makeUserManager(user1)).thenReturn(true);
        when(userCasesMock.getUserName(contract)).thenReturn("test");
        when(userCasesMock.getAllContractsForUser("a@2.ru")).thenReturn(contractList);
    }

    @Test(expected = CustomDAOException.class)
    public void makeUserManager() {
        Assert.assertEquals(userCasesMock.makeUserManager(user2), true);
    }

    @Test
    public void makeUserManagerOne() {
        Assert.assertEquals(userCasesMock.makeUserManager(user1), true);
    }


    @Test
    public void getUserName() throws Exception {
        Assert.assertEquals(userCasesMock.getUserName(contract), "test");
    }

    @Test
    public void isManager() throws Exception {
        Assert.assertEquals(userCasesMock.isManager("b@b.ru"), true);
        Assert.assertEquals(userCasesMock.isManager("a@2.ru"), false);
    }

    @Test
    public void getAllContractsForUser() throws Exception {
        Assert.assertEquals(userCasesMock.getAllContractsForUser("a@2.ru").size(), 0);
    }

}