package operator.servlets;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import operator.services.implementation.AccessLevelImpl;
import operator.services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


// TODO: 9/4/16  прибраться в коде. Все засрано. особенно в сервлетах
// TODO: 9/9/16 переписывать все на jstl
// TODO: 9/13/16 refresh problem

// TODO: 9/7/16 1) Not update content after first changing on user/Tariffs

/**
 * Created by Artyom Karnov on 8/29/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Servlet for authorization controlling
 */
public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    private AccessLevelImpl accessLevelService = new AccessLevelImpl();
    public static boolean isPreviousDataCorrect = true;

    /**
     * Method for user authorization
     * @param eMail Email for checking
     * @param password Password for checking
     * @return true - if user with current data exists, else if doesn't
     */
    public boolean isAuthorized(String eMail, String password) {
        User user;
        try {
            user = userService.getUserByEMAil(eMail);
            if (user.getPassword().equals(password))
                return true;
            else return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        } catch (UserNotFoundException ex) {
            return false;
        }
    }

    public boolean isManager(String eMail) {
        return userService.getUserByEMAil(eMail).getAccessLevel() != null ? true : false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = (String) req.getSession(true).getAttribute("eMail");
        if (isManager(eMail)) {
            req.getSession(true).setAttribute("userName", userService.getUserByEMAil(eMail).getName());
            req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req, resp);
        } else {
            req.getSession(true).setAttribute("userName", userService.getUserByEMAil(eMail).getName());
            req.getRequestDispatcher("/WEB-INF/user/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String eMail = req.getParameter("username");
        String password = req.getParameter("password");
        String userName;
        if (isAuthorized(eMail, password)) {
            userName = userService.getUserByEMAil(eMail).getName();
            req.setAttribute("userName", userName);
            req.getSession(true).setAttribute("userName", userName);
            req.getSession(true).setAttribute("eMail", eMail);
            isPreviousDataCorrect = true;
            if (isManager(eMail)) {
                req.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
            }
        } else {
            isPreviousDataCorrect = false;
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
