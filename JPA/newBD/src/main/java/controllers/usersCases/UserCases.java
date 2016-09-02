package controllers.usersCases;

import entities.TariffOption;
import entities.User;
import exceptions.OptionsForEntityNotGotException;
import exceptions.UserNotFoundException;
import services.api.AccessLevelService;
import services.api.UserService;
import services.implementation.AccessLevelImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.UserServiceImpl;

import javax.persistence.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/
public class UserCases {
    UserService userService = new UserServiceImpl();

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("operator");
    protected EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        UserCases userCases = new UserCases();
        TariffOptionServiceImpl optionService = new TariffOptionServiceImpl();
        TariffOption one = optionService.getEntityById(1);
        TariffOption two = optionService.getEntityById(2);
        System.out.println(one);
        System.out.println(two);
//        System.out.println(optionService.getAllImpossibleTariffOption(3).size());
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

    static public String getUserName(HttpServletRequest req) {
        String eMail = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("eMail")) eMail = cookie.getValue();
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);
        return user.getName();

    }

//    public boolean areOptionsPossible(TariffOption first, TariffOption second) {
//        try {
////            Query query = entityManager.createQuery("select t from Tariff t where title=:title")
////                    .setParameter("title", title);
//            Query query = entityManager.createQuery("select t from impossibleOtions t where tariffOption_id=:id")
//                    .setParameter("id", first.getTariffOptionId());
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            return false;
//        }
//    }

}
