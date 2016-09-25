package operator.controllers;

import operator.entities.User;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Locale locale, Model model) {
        System.out.println("Here");
        return "index";
    }

    /**
     * This method returns the login page when logout is required.
     *
     * @return login.jsp
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage() {

        return "index";
    }

    /**
     * This method returns an error403 page when a restricted access page is called.
     *
     * @return denied.jsp
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String deniedPage() {
        return "";
    }

    /**
     * This method returns a login page with an error block after an unsuccessful attempt.
     *
     * @param locale locale;
     * @param model  model;
     * @return login.jsp
     */
    @RequestMapping(value = "/login-denied", method = RequestMethod.GET)
    public String loginDenied(Locale locale, Model model) {
        model.addAttribute("isInputValid", "false");
        return "index";
    }

    /**
     * This method dispatches the requests to the starting page of an employee or to the one of a user.
     * It also sets the current user entity into session.
     *
     * @param request request;
     * @param locale  locale;
     * @param model   model;
     * @return cp_employee_main.jsp or cp_client_main.jsp
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String dispatch(HttpServletRequest request, Locale locale, Model model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.getUserByEMAil(user.getUsername());
        request.getSession().setAttribute("currentUserU", currentUser);
        request.getSession().setAttribute("language", RussianLanguage.getRussianLanguage());
        if (currentUser.getAccessLevel() == null) {
            return "user/index";
        } else {
            return "admin/index";
        }
    }
}
