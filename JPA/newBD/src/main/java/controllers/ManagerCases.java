package controllers;

import entities.Contract;
import entities.Tariff;
import entities.TariffOption;
import entities.User;
import exceptions.ContractNotFoundException;
import exceptions.UserNotFoundException;
import services.api.TariffOptionService;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.TariffServiceImpl;
import services.implementation.UserServiceImpl;

import java.util.List;
import java.util.Random;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/
public class ManagerCases {
    private UserServiceImpl userService = new UserServiceImpl();
    private ContractServiceImpl contractService = new ContractServiceImpl();
    TariffServiceImpl tariffService = new TariffServiceImpl();
    TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();

    public boolean isUserExists(String eMail) {
        try {
            userService.getUserByEMAil(eMail).getEmail();
        } catch (UserNotFoundException ex) {
            return false;
        }
        return true;
    }

    public void addUserToBase(String name, String secondName, String birthdayData,
                              String passport, String adress,
                              String email, String password) {
        User user = new User(name, secondName, birthdayData,
                passport, adress,
                email, password);
        userService.createEntity(user);
    }

    public boolean isNumberExists(String number) {
        try {
            contractService.getContractByNumber(number);
        } catch (ContractNotFoundException ex) {
            return false;
        }
        return true;
    }

    public boolean isTariffExists(String title) {
        for (Tariff tariff : tariffService.getAll()) {
            if (tariff.getTitle().equals(title))
                return true;
        }
        return false;
    }

    public void addTariffToBase(String title, String price) {
        Tariff tariff = new Tariff(title, Double.parseDouble(price));
        tariffService.createEntity(tariff);
    }

    public void addContractToBase(String eMail, String number) {

        Contract contract = new Contract(number, userService.getUserByEMAil(eMail),
                tariffService.getTariffByTitle("base"));
        contractService.createEntity(contract);
    }

    public boolean isOptionExists(String title) {
        for (TariffOption tariffOption : tariffOptionService.getAll()) {
            if (tariffOption.getTitle().equals(title))
                return true;
        }
        return false;
    }

    public void addOptionToBase(String title, String price, String connectionPrice) {
        TariffOption tariffOption = new TariffOption(title, Double.parseDouble(price),
                Double.parseDouble(connectionPrice));
        tariffOptionService.createEntity(tariffOption);
    }

    public String passwordGenerator(int size) {
        Random rand = new Random();
        int num;
        StringBuilder sb = new StringBuilder();
        String set = "abcdefjhijklmnoprstuqwzxyz0123456789!@#$%^&*()";
        for (int i = 0; i < size; i++) {
            num = rand.nextInt(set.length() - 1);
            sb.append(set.charAt(num));
        }
        String result = sb.toString();
        return result;
    }

    public void addJoinOptionToBase(String tariffOne, String tarifftwo) {
        TariffOption one = null, two = null;
        for (TariffOption tariffOption : tariffOptionService.getAll()) {
            if (tariffOption.getTitle().equals(tariffOne))
                one = tariffOption;
            if (tariffOption.getTitle().equals(tarifftwo))
                two = tariffOption;
        }
        one.addjointTogether(two);
        two.addjointTogether(one);
        tariffOptionService.updateEntity(one);
        tariffOptionService.updateEntity(two);
    }

    public void addImmposibleOptionToBase(String tariffOne, String tarifftwo) {
        TariffOption one = null, two = null;
        for (TariffOption tariffOption : tariffOptionService.getAll()) {
            if (tariffOption.getTitle().equals(tariffOne))
                one = tariffOption;
            if (tariffOption.getTitle().equals(tarifftwo))
                two = tariffOption;
        }
        one.addOptionsIncompatible(two);
        two.addOptionsIncompatible(one);
        tariffOptionService.updateEntity(one);
        tariffOptionService.updateEntity(two);
    }
}
