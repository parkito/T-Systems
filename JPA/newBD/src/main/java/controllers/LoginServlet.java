package controllers;

import controllers.usersCases.UserCases;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


// TODO: 9/4/16 избаватсья от падений вначале
// TODO: 9/4/16 страницы 404
// TODO: 9/4/16  выход из систмы продумать
// TODO: 9/4/16  прибраться в коде. Все засрано. особенно в сервлетах
// TODO: 9/4/16  разобраться с блокировками тарифных опций
// TODO: 9/4/16  дизайн менеджеров
// TODO: 9/4/16  писать для менедэеров
// TODO: 9/4/16 что можно сделать с пустыми списками? 

/**
 * Created by Artyom Karnov on 8/29/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/4/16 thinking about failining during loginin
public class LoginServlet extends HttpServlet {
    UserCases userCases = new UserCases();
    public static boolean isPreviousDataCorrect = true;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
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
            if (userCases.isManager(eMail)) {
                req.getRequestDispatcher("WEB-INF/manager/index.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
            }
        } else {
            isPreviousDataCorrect = false;
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
