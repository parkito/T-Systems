package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 8/29/16.
 * artyom-karnov@yandex.ru
 **/

public class Login extends HttpServlet {
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
        System.out.println("POST here");
        System.out.println(req.getParameter("username"));
        req.getRequestDispatcher("/demo/").forward(req, resp);
//        resp.sendRedirect("/demo/");
    }
}
