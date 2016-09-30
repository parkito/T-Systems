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
// TODO: 9/24/16 Продумать штуку про разрешенные тарифы. Видно, что в базе надо впихивать что-то
// TODO: 9/27/16 Испраить фигню с аджаксом 
// TODO: 9/27/16 Исправить фигню с тарифными опциями, которые хер пойми как групируюся
// TODO: 9/30/16 При лог ауте вылетает надпись о неправильном логине и пароле
@Controller("LoginController")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;

    /**
     * Method for dispatching requests to login page
     *
     * @param locale locale for page
     * @param model  model for page view
     * @return page for view login
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Locale locale, Model model) {
        model.addAttribute("userData", true);
        return "index";
    }

    /**
     * Method for logout
     *
     * @param model model for page view
     * @return page for logout
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(Model model) {
        model.addAttribute("userData", false);
        return "index";
    }

    /**
     * Method for denied actions
     *
     * @return page for denied
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String deniedPage() {
        return "Help";
    }

    /**
     * This method returns a login page with an error block after an unsuccessful attempt.
     *
     * @param locale locale;
     * @param model  model;
     * @return login.jsp
     */
    @RequestMapping(value = "/login-denied", method = RequestMethod.GET)
    public String loginDenied(HttpServletRequest req, Locale locale, Model model) {
        model.addAttribute("userData", false);
        return "index";
    }

    /**
     * Method for dispatching requests to admin's and user's pages
     *
     * @param request
     * @param locale
     * @param model
     * @return adjusted page
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, Locale locale, Model model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.getUserByEMAil(user.getUsername());
        request.getSession().setAttribute("currentUser", currentUser);
        if (currentUser.getAccessLevel().getAccessLevelId() == 1) {
            return "user/index";
        } else if (currentUser.getAccessLevel().getAccessLevelId() == 3) {
            return "admin/index";
        } else return "login";
    }
}
