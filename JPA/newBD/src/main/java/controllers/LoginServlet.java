package controllers;

import controllers.usersCases.UserCases;

import javax.servlet.ServletException;
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
        System.out.println("LoginServlet initialization ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userPath = req.getServletPath();
        System.out.println("Get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post");
        String eMail = req.getParameter("username");
        String password = req.getParameter("password");
        UserCases userCases = new UserCases();
        if (userCases.isAuthorized(eMail, password))
//            resp.sendRedirect("/home/index.jsp");
            req.getRequestDispatcher("WEB-INF/user/index.jsp").forward(req, resp);
        else {
            isPreviousDataCorrect = false;
            req.getRequestDispatcher("index.jsp").forward(req, resp);
//            resp.sendRedirect("/index.jsp");
        }
    }
}
