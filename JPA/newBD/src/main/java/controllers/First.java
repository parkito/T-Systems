package controllers;

import entities.Contract;
import entities.TariffOption;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.UserServiceImpl;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/


// TODO: 8/31/16 unic status for accsess level
public class First {
    public static void main(String[] args) {
        //1) add roles for users
//        AccessLevelService levelService = new AccessLevelImpl();
//        AccessLevel accessLevel = new AccessLevel("userAvailable");
//        AccessLevel accessLevel1 = new AccessLevel("userBanned");
//        AccessLevel accessLevel2 = new AccessLevel("Manager");
//        levelService.createEntity(accessLevel);
//        levelService.createEntity(accessLevel1);
//        levelService.createEntity(accessLevel2);

        //for test

//        UserServiceImpl userService = new UserServiceImpl();
//        System.out.println(userService.getUserByEMAil("c@b.ru"));

        //2) add users
//        User user0 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "spb", "a@b.ru", "1234");
//        User user1 = new User("Ivan", "Ivanov", "08.10.1990", "pass1", "spb", "a@2.ru", "1234");
//        User user2 = new User("Ivan", "Petrov", "05.05.1995", "pass2", "nn", "b@b.ru", "12345");
//        User user3 = new User("Ivan", "Kirillov", "12.11.1950", "pass3", "dzr", "c@b.ru", "12346");
//        User user4 = new User("Artem", "Ivanov", "07.10.1990", "pass4", "msk", "d@b.ru", "12347");
//        User user5 = new User("Kirill", "Ivanov", "18.11.1999", "pass5", "ny", "e@b.ru", "12348");
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createEntity(user1);
//        userService.createEntity(user2);
//        userService.createEntity(user3);
//        userService.createEntity(user4);
//        userService.createEntity(user5);

        //3) add Tariffs
//        Tariff tariff1 = new Tariff("base", 50.0);
//        Tariff tariff2 = new Tariff("gb1", 50.0);
//        Tariff tariff3 = new Tariff("gb2", 100.0);
//        Tariff tariff4 = new Tariff("call1", 50.0);
//        Tariff tariff5 = new Tariff("call2", 150.0);
//        Tariff tariff6 = new Tariff("unlim", 200.0);
//        TariffServiceImpl tariffService = new TariffServiceImpl();
//        tariffService.createEntity(tariff1);
//        tariffService.createEntity(tariff2);
//        tariffService.createEntity(tariff3);
//        tariffService.createEntity(tariff4);
//        tariffService.createEntity(tariff5);
//        tariffService.createEntity(tariff6);

        //4) add TariffOptions
//        TariffOption tariffOption = new TariffOption("basic", 50.0, 0.0);
//        TariffOption tariffOption1 = new TariffOption("addbg1", 100.0, 50.0);
//        TariffOption tariffOption2 = new TariffOption("addgb2", 150.0, 100.0);
//        TariffOption tariffOption3 = new TariffOption("addcall1", 50.0, 0.0);
//        TariffOption tariffOption4 = new TariffOption("addcall2", 150.0, 100.0);
//        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
//        tariffOptionService.createEntity(tariffOption);
//        tariffOptionService.createEntity(tariffOption1);
//        tariffOptionService.createEntity(tariffOption2);
//        tariffOptionService.createEntity(tariffOption3);
//        tariffOptionService.createEntity(tariffOption4);

        //5) addContract

        // TODO: 8/30/16 getTariffByTittle 
//        TariffServiceImpl tariffService = new TariffServiceImpl();
//        UserServiceImpl userService = new UserServiceImpl();
//        Tariff tariff1 = tariffService.getEntityById(1);
//        User user0 = userService.getUserByEMAil("e@b.ru");
//        ContractServiceImpl contractService = new ContractServiceImpl();
//        Contract contract = new Contract("214189", user0, tariff1);
//        contractService.createEntity(contract);
//        tariff1 = tariffService.getEntityById(2);
//        user0 = userService.getUserByEMAil("b@b.ru");
//        contract = new Contract("214190", user0, tariff1);
//        contractService.createEntity(contract);
//        tariff1 = tariffService.getEntityById(3);
//        user0 = userService.getUserByEMAil("c@b.ru");
//        contract = new Contract("214191", user0, tariff1);
//        contractService.createEntity(contract);

        //6) add TariffOption to contract

//        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
//        ContractServiceImpl contractService = new ContractServiceImpl();
//        Contract contract = contractService.getContractByNumber("214189");
//        contract.addOption(tariffOptionService.getEntityById(2));
//        contract.addOption(tariffOptionService.getEntityById(5));
//        contractService.updateEntity(contract);
//        contract=contractService.getContractByNumber("214190");
//        contract.addOption(tariffOptionService.getEntityById(1));
//        contract.addOption(tariffOptionService.getEntityById(3));
//        contract.addOption(tariffOptionService.getEntityById(4));
//        contractService.updateEntity(contract);


        //7) add possible and joint TariffOptions
//        ContractServiceImpl contractService = new ContractServiceImpl();
//        Contract contract = contractService.getEntityById(2);
//        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
//        TariffOption tar1 = tariffOptionService.getEntityById(1);
//        TariffOption tar2 = tariffOptionService.getEntityById(2);
//        TariffOption tar3 = tariffOptionService.getEntityById(3);
//        tar2.addOptionsIncompatible(tar2);
//        tar2.addjointTogether(tar2);
//        tariffOptionService.updateEntity(tar2);

//        System.out.println(tar1);
//        System.out.println(tar2);
//        System.out.println(tar3);

//        List<TariffOption> tariffOptions = tariffOptionService.getAllImpossibleTariffOption(tar1.getTariffOptionId());
//        List<TariffOption> tariffOptions = tariffOptionService.getAllJoinedTariffOption(tar2.getTariffOptionId());
//
//        for (TariffOption option : tariffOptions) {
//            System.out.println(option);
//        }
//
//
        UserServiceImpl userService = new UserServiceImpl();
        userService.getEntityById(2);
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contractList = contractService.getAllContractsForUser(2);
        for (Contract contract : contractList) {
            System.out.println(contract.getNumber() + " " + contract.isBlocked());
        }
        Contract newContract = contractList.get(0);
        newContract.setBlocked(true);
    }
}