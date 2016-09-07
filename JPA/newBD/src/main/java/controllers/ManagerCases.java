package controllers;

import entities.Contract;
import entities.User;
import exceptions.ContractNotFoundException;
import exceptions.UserNotFoundException;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffServiceImpl;
import services.implementation.UserServiceImpl;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/
public class ManagerCases {
    private UserServiceImpl userService = new UserServiceImpl();
    private ContractServiceImpl contractService = new ContractServiceImpl();
    TariffServiceImpl tariffService = new TariffServiceImpl();

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

    public void addContractToBase(String eMail, String number) {

        Contract contract = new Contract(number, userService.getUserByEMAil(eMail),
                tariffService.getTariffByTitle("base"));
        contractService.createEntity(contract);
    }

}
