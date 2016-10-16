package operator.controllers;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import operator.services.api.ContractService;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Artyom Karnov on 9/24/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/24/16 Продумать штуку про разрешенные тарифы. Видно, что в базе надо впихивать что-то
// TODO: 10/2/16 Продумать удаление пользователей. Проблема с зависимостями и вся черемуха
// TODO: 10/2/16 Что с поиском?  Придумаешь фичу?
// TODO: 10/2/16 Оптимизируй это. Повторение в коде из за неподхвата user кейсов админом
// TODO: 10/2/16 Во многих местах ты можешь избавиться от скриплетов - действуй
// TODO: 10/4/16 При добавление нового тарифа не выскакивает надпись о том что тариф добавлен
// TODO: 10/7/16 Проблема юзров об обновлении корзины

/**
 * Login controller
 */
@Controller("LoginController")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;
    @Autowired
    UserCases userCases;
    @Autowired
    ManagerCases managerCases;

    /**
     * Method for dispatching requests to login page
     *
     * @param model model for page view
     * @return page for view login
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
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
    public String logoutPage(Model model, HttpServletRequest req) throws ServletException {
        req.getSession().invalidate();
        req.logout();
        model.addAttribute("userData", true);
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
     * @param model model;
     * @return login.jsp
     */
    @RequestMapping(value = "/login-denied", method = RequestMethod.GET)
    public String loginDenied(HttpServletRequest req, Model model) {
        model.addAttribute("userData", false);
        return "index";
    }

    /**
     * Method for dispatching requests to admin's and user's pages
     *
     * @param request
     * @param model
     * @return adjusted page
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest req, Model model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.getUserByEMAil(user.getUsername());
        currentUser.setPassword("");
        currentUser.setBirthdayData("");
        currentUser.setSecondName("");
        req.getSession().setAttribute("currentUser", currentUser);
        if (currentUser.getAccessLevel().getAccessLevelId() == 1) {
            req.getSession().setAttribute("userPayment", userCases.getPaymentInfo(currentUser));
            return "user/index";
        } else if (currentUser.getAccessLevel().getAccessLevelId() == 3) {
            return "admin/index";
        } else return "login";
    }

    /**
     * Method for dispatching requests to rememberMe
     *
     * @return remember me page
     */
    @RequestMapping(value = "/rememberMe", method = RequestMethod.GET)
    public String rememberMe() {
        return "rememberMe";
    }

    /**
     * Method for dispatching requests to rememberMe
     *
     * @param model model;
     * @param email user's email
     * @return remember me page
     */
    @RequestMapping(value = "/rememberMe", method = RequestMethod.POST)
    public String rememberMePost(Model model,
                                 @RequestParam(value = "email") String email) {
        User user;
        try {
            user = userService.getUserByEMAil(email);
            model.addAttribute("remindCheck", true);
            user.setPassword(managerCases.passwordGenerator(5, "", user.getEmail(), user.getName()));
            userService.updateEntity(user);
        } catch (UserNotFoundException ex) {
            model.addAttribute("remindCheck", false);
        }
        return "rememberMe";
    }

}
