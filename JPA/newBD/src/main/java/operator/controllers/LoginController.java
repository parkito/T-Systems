package operator.controllers;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import operator.services.api.ContractService;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Artyom Karnov on 9/24/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/24/16 Изменить в дао о существующих пользователях действия. Не по провославному это
// TODO: 9/24/16 Продумать штуку про разрешенные тарифы. Видно, что в базе надо впихивать что-то
// TODO: 9/26/16 у меня спринг секурити не задейстован!!!
// TODO: 9/27/16 Испраить фигню с аджаксом 
// TODO: 9/27/16 Исправить фигню с тарифными опциями, которые хер пойми как групируюся 
@Controller("LoginController")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;




    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, Locale locale, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(auth.getDetails());
        System.out.println(auth.getPrincipal());
        System.out.println(principal);
        return "index";


    }
//        try {
//            User currentUser = userService.getUserByEMAil(username);
//            if (currentUser.getPassword().equals(pass)) {
//                request.getSession().setAttribute("currentUser", currentUser);
//                if (currentUser.getAccessLevel().getAccessLevelId() == 1) {
//                    return "user/index";
//                } else if (currentUser.getAccessLevel().getAccessLevelId() == 3) {
//                    return "admin/index";
//                }
//            }
//        } catch (UserNotFoundException ex) {
//            return "index";
//        }
//        return "user/index";

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}


//}
