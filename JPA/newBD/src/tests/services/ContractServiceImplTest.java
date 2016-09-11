package services;

import entities.Contract;
import entities.Tariff;
import services.api.UserService;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffServiceImpl;
import services.implementation.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Artyom Karnov on 9/8/16.
 * artyom-karnov@yandex.ru
 **/
public class ContractServiceImplTest  {
    UserService userService = new UserServiceImpl();
    TariffServiceImpl tariffService = new TariffServiceImpl();
    ContractServiceImpl contractService = new ContractServiceImpl();
    Contract contract;

    @Before
    public void initTest() {
        Tariff tariff = tariffService.getEntityById(1);
        contract = new Contract("2141100", userService.getUserByEMAil("c@c.ru"), tariff);
    }

    @Test

    public void createEntity() throws Exception {
        contractService.createEntity(contract);
    }

    @Test
    public void getEntityById() throws Exception {
        Assert.assertEquals(contractService.getEntityById(1).getNumber(), "214189");

    }

    @Test
    public void updateEntity() throws Exception {
        contract = contractService.getEntityById(1);
        if (contract.getIsBlocked()) {
            contract.setIsBlocked(false);
            contractService.updateEntity(contract);
            Assert.assertEquals(contract.getIsBlocked(), false);
        } else {
            contract.setBlocked(true);
            contractService.updateEntity(contract);
            Assert.assertEquals(contract.getIsBlocked(), true);
        }
    }

    @Test
    public void deleteEntity() throws Exception {
        contractService.deleteEntity(contract);
    }

    @Test
    public void getContractByNumber() throws Exception {
        contract = contractService.getContractByNumber("214189");
        Assert.assertEquals(contract.getNumber(), "214189");
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertNotEquals(contractService.getAll().size(), 0);
    }

    @Test
    public void getAllContractsForUser() throws Exception {
        List<Contract> contractList = contractService.getAllContractsForUser(1);
        Assert.assertNotEquals(contractList.size(), 1);
    }

    @Test
    public void isContractExists() throws Exception {
        Assert.assertEquals(contractService.isContractExists(contract), true);
    }

}