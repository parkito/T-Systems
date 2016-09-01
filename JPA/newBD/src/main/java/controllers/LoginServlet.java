package controllers;

import controllers.usersCases.UserCases;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 8/29/16.
 * artyom-karnov@yandex.ru
 **/

public class LoginServlet extends HttpServlet {
    public static boolean isPreviousDataCorrect = true;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HERE");
        String eMail;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("eMail")) eMail = cookie.getValue();
            req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/404.jsp").forward(req, resp);
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
            req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
        } else {
            isPreviousDataCorrect = false;
            req.getRequestDispatcher("index.jsp").forward(req, resp);
//            resp.sendRedirect("/index.jsp");
        }
    }
}
