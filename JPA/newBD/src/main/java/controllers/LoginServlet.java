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
//            resp.sendRedirect("/home/");
            req.getRequestDispatcher("WEB-INF/home/index.jsp").forward(req, resp);
        else {
            System.out.println("error");
            resp.sendRedirect("/index.jsp");
        }
    }
}
