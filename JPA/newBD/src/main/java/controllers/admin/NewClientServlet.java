package controllers.admin;

import controllers.ManagerCases;
import services.implementation.UserServiceImpl;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/
public class NewClientServlet extends HttpServlet {
    private ManagerCases managerCases = new ManagerCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession(true).setAttribute("nameStat", "1");
//        req.getSession(true).setAttribute("surNameStat", "");
//        req.getSession(true).setAttribute("birthday", "");
//        req.getSession(true).setAttribute("passport", "");
//        req.getSession(true).setAttribute("adress", "");
//        req.getSession(true).setAttribute("email", "");
//        req.getSession(true).setAttribute("password", "");
        req.getRequestDispatcher("/WEB-INF/admin/NewClient.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String secondName = req.getParameter("surName");
        String birthdayDate = req.getParameter("birthday");
        String passport = req.getParameter("passport");
        String adress = req.getParameter("adress");
        String eMail = req.getParameter("email");
        String password = req.getParameter("password");

        req.getSession(true).setAttribute("nameStat", "OK");
        req.getSession(true).setAttribute("surNameStat", "OK");
        req.getSession(true).setAttribute("birthday", "OK");
        req.getSession(true).setAttribute("passport", "OK");
        req.getSession(true).setAttribute("adress", "OK");

        if (!managerCases.isUserExists(eMail)) {
            req.getSession(true).setAttribute("email", "Error");
        } else {
            req.getSession(true).setAttribute("email", "OK");
        }
        req.getSession(true).setAttribute("password", "OK");

    }
}
