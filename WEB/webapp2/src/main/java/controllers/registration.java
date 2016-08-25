package controllers;

import manipulating.ClientDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 8/25/16.
 * artyom-karnov@yandex.ru
 **/
@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();
        System.out.println("Get");
        request.getRequestDispatcher("/WEB-INF/views" + userPath + ".jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post");
        String userPath = request.getServletPath();
        ClientDAO clientDAO = new ClientDAO();
        String name = request.getParameter("name");
        String secondName = request.getParameter("secondName");
        String birthdayData = request.getParameter("birthdayDate");
        String passport = request.getParameter("passport");
        String adress = request.getParameter("adress");
        String eMail = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(name + " " + secondName + " " + birthdayData + " " + passport + " " + adress + " " + eMail + " " + password);
        clientDAO.addClient("Artyom", "Karnov", "08.02.1995", "data", "spb", "artyom @karnov.ru", "1122");
//        clientDAO.addClient(
//                name, secondName,
//                birthdayData, passport,
//                adress, eMail,
//                password
//        );

    }
}
