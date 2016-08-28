package controllers;

import entities.User;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 8/28/16.
 * artyom-karnov@yandex.ru
 **/
@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("RegistrationServlet initialization ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userPath = req.getServletPath();
        System.out.println("Get");
        req.getRequestDispatcher("/WEB-INF/views" + userPath + ".jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post");
        String name = req.getParameter("name");
        String secondName = req.getParameter("secondName");
        String birthdayData = req.getParameter("birthdayDate");
        String passport = req.getParameter("passport");
        String adress = req.getParameter("adress");
        String eMail = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(name + " " + secondName + " " + birthdayData + " " + passport + " " + adress + " " + eMail + " " + password);
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User(name, secondName, birthdayData, passport, adress, eMail, password);
    }
}
