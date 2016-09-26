package operator.controllers;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import operator.services.api.ContractService;
import operator.services.api.UserService;
import operator.utils.Locale.RussianLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Artyom Karnov on 9/24/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/24/16 Изменить в дао о существующих пользователях действия. Не по провославному это
// TODO: 9/24/16 Продумать штуку про разрешенные тарифы. Видно, что в базе надо впихивать что-то
// TODO: 9/26/16 у меня спринг секурити не задейстован!!!
@Controller("LoginController")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String eMail, @RequestParam("password") String pass) {
        try {
            User user = userService.getUserByEMAil(eMail);
            if (user.getPassword().equals(pass))
                return "user/index";
            else return "404";
        } catch (UserNotFoundException ex) {
            System.out.println("error");
        }
        return "index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String dispatch(HttpServletRequest request, Locale locale, Model model,
//                           @RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "username", required = false) String username,
                           @RequestParam(value = "password", required = false) String pass) {
//        System.out.println(error + " " + username + " " + pass);
        try {
            User currentUser = userService.getUserByEMAil(username);
            System.out.println(currentUser);
            if (currentUser.getPassword().equals(pass)) {
                request.getSession().setAttribute("currentUser", currentUser);
                if (currentUser.getAccessLevel()==null) {
                    return "user/index";
                } else if (currentUser.getAccessLevel().getAccessLevelId() == 3) {
                    return "admin/index";
                }
            }
        } catch (UserNotFoundException ex) {
            return "index";
        }
        return "index";
    }


}
