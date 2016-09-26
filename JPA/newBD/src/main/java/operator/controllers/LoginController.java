package operator.controllers;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import operator.services.api.UserService;
import operator.utils.Locale.RussianLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@Controller("LoginController")
public class LoginController {
    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home(Locale locale, Model model) {
//
//        return "index";
//    }

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

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String dispatch(HttpServletRequest request, Locale locale, Model model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.getUserByEMAil(user.getUsername());
        request.getSession().setAttribute("currentUserU", currentUser);
        request.getSession().setAttribute("language", RussianLanguage.getRussianLanguage());
        if (currentUser.getAccessLevel().getAccessLevelId() == 1) {
            return "user/index";
        }
        else if (currentUser.getAccessLevel().getAccessLevelId() == 3){
            return "admin/index";
        }
        else return "index";
    }

}
