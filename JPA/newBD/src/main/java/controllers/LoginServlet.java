package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


// TODO: 9/4/16  прибраться в коде. Все засрано. особенно в сервлетах
// TODO: 9/4/16  разобраться с блокировками тарифных опций
// TODO: 9/4/16  дизайн менеджеров
// TODO: 9/4/16  писать для менедэеров
// TODO: 9/4/16 что можно сделать с пустыми списками? т.е. когда на странице нет ни одного элемента.
// TODO: 9/7/16 documentation  
// TODO: 9/7/16 tests
// TODO: 9/7/16 try to change jsp on tag-style

// TODO: 9/7/16 errors
// TODO: 9/7/16 1) Not update content after first changing on user/Tariffs
// TODO: 9/7/16 2) Incorrect login status after sign out (users)
// TODO: 9/7/16 3) /admin/NewClient - null from srtatch
// TODO: 9/7/16 5) http://localhost:8080/admin/NewClient - mistaken access
// TODO: 9/7/16 6) for security set up getting password from session
// TODO: 9/7/16 7) not remoning session after log out 
// TODO: 9/7/16 8) If there is session - on localhost:8080 open /login, not signIn
// TODO: 9/7/16 10) Change clien multi window on manegers main page
// TODO: 9/7/16 11) fuckin shit with email on registration

/**
 * Created by Artyom Karnov on 8/29/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/4/16 thinking about failining during loginin
public class LoginServlet extends HttpServlet {
    private UserCases userCases = new UserCases();
    public static boolean isPreviousDataCorrect = true;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userCases.isManager(userCases.getCookiesValue(req, "eMail"))) {
            req.getSession(true).setAttribute("userName", userCases.getUserName(req));
            req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req, resp);
        } else {
            req.getSession(true).setAttribute("userName", userCases.getUserName(req));
            req.getRequestDispatcher("/WEB-INF/user/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = req.getParameter("username");
        String password = req.getParameter("password");
        String userName;
        if (userCases.isAuthorized(eMail, password)) {
            userName = userCases.getUserNameByEmail(eMail);
            Cookie loginCookie = new Cookie("eMail", eMail);
            Cookie userNameCookie = new Cookie("userName", userName);
            loginCookie.setMaxAge(30 * 60);
            userNameCookie.setMaxAge(30 * 60);
            resp.addCookie(loginCookie);
            resp.addCookie(userNameCookie);
            req.setAttribute("userName", userName);
            req.getSession(true).setAttribute("userName", userName);
            req.getSession(true).setAttribute("eMail", eMail);
            isPreviousDataCorrect = true;
            if (userCases.isManager(eMail)) {
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
