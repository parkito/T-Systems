package controllers.usersCases;

import entities.Contract;
import entities.TariffOption;
import entities.User;
import exceptions.UserNotFoundException;
import services.api.AccessLevelService;
import services.api.UserService;
import services.implementation.AccessLevelImpl;
import services.implementation.ContractServiceImpl;
import services.implementation.UserServiceImpl;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/
public class UserCases {
    UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        UserCases userCases = new UserCases();
        UserServiceImpl userService = new UserServiceImpl();
        userCases.makeUserManager(userService.getUserByEMAil("b@b.ru"));
    }

    public boolean isAuthorized(String eMail, String password) {
        try {
            User user = userService.getUserByEMAil(eMail);
            if (user.getPassword().equals(password))
                return true;
            else return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        } catch (UserNotFoundException ex) {
            return false;
        }
    }

    public void makeUserManager(User user) {
        AccessLevelService accessLevelService = new AccessLevelImpl();
        UserServiceImpl userService = new UserServiceImpl();
        userService.cahngeUserAccessLevel(user, accessLevelService.getEntityById(3));
    }

    public void watchConracts(User user) {
        System.out.println("Enter");
        ContractServiceImpl contractService = new ContractServiceImpl();
        if (contractService.getAllContractsForUser(user.getUserId()).size() == 0)
            System.out.println("User haven't got any contracts ");
        else {
            for (Contract contract : contractService.getAllContractsForUser(user.getUserId())) {
                System.out.println("Contract " + contract.getNumber());
                System.out.println(contract.getTariff());
                System.out.println("Connected tariff options");
                for (TariffOption tariffOption : contract.getTariffOptions()) {
                    System.out.println(tariffOption.getTitle() + tariffOption.getPrice());
                }
            }
        }
    }
}
