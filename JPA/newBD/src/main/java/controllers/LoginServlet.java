package controllers;

import entities.User;
import exceptions.UserNotFoundException;
import services.implementation.AccessLevelImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


// TODO: 9/4/16  прибраться в коде. Все засрано. особенно в сервлетах
// TODO: 9/4/16  дизайн менеджеров
// TODO: 9/4/16  писать для менедэеров
// TODO: 9/4/16 что можно сделать с пустыми списками? т.е. когда на странице нет ни одного элемента.
// TODO: 9/7/16 documentation  
// TODO: 9/7/16 tests
// TODO: 9/9/16 переписывать все на jstl

// TODO: 9/7/16 1) Not update content after first changing on user/Tariffs
// TODO: 9/7/16 2) Incorrect login status after sign out (users)
// TODO: 9/7/16 3) /admin/NewClient - null from srtatch
// TODO: 9/7/16 5) http://localhost:8080/admin/NewClient - mistaken access
// TODO: 9/7/16 6) for security set up getting password from session
// TODO: 9/7/16 7) not remoning session after log out 
// TODO: 9/7/16 8) If there is session - on localhost:8080 open /login, not signIn
// TODO: 9/7/16 10) Change clien multi window on manegers main page

/**
 * Created by Artyom Karnov on 8/29/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/4/16 thinking about failining during loginin
public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    private AccessLevelImpl accessLevelService = new AccessLevelImpl();
    public static boolean  isPreviousDataCorrect = true;

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
