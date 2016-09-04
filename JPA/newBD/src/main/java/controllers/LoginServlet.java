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
    public static boolean isPreviousDataCorrect = true;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = UserCases.getCookiesValue(req,"eMail");
            req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
//        }
//        req.getRequestDispatcher("/404.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = req.getParameter("username");
        String password = req.getParameter("password");
        UserCases userCases = new UserCases();
        if (userCases.isAuthorized(eMail, password)) {
//            resp.sendRedirect("/home/index.jsp");
            Cookie loginCookie = new Cookie("eMail", eMail);
            loginCookie.setMaxAge(30 * 60);
            resp.addCookie(loginCookie);
            if (UserCases.isManager(eMail)) {
                System.out.println("manager");
                req.getRequestDispatcher("WEB-INF/manager/index.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
            }
        } else {
            isPreviousDataCorrect = false;
            req.getRequestDispatcher("index.jsp").forward(req, resp);
//            resp.sendRedirect("/index.jsp");
        }
    }
}
