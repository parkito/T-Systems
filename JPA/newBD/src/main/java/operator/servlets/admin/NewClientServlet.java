package operator.servlets.admin;

import operator.controllers.ManagerCases;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Servlet for new client controlling
 */
public class NewClientServlet extends HttpServlet {
    private ManagerCases managerCases = new ManagerCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/adminNewClient.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean add = true;

        String name = req.getParameter("name");
        String secondName = req.getParameter("surName");
        String birthdayDate = req.getParameter("birthday");
        String passport = req.getParameter("passport");
        String adress = req.getParameter("adress");
        String eMail = req.getParameter("email");


        if (name.equals("")) {
            req.getSession(true).setAttribute("nameStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("nameStat", "OK");

        if (secondName.equals("")) {
            req.getSession(true).setAttribute("surNameStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("surNameStat", "OK");

        if (birthdayDate.equals("")) {
            req.getSession(true).setAttribute("birthday", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("birthday", "OK");

        if (passport.equals("")) {
            req.getSession(true).setAttribute("passport", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("passport", "OK");

        if (adress.equals("")) {
            req.getSession(true).setAttribute("adress", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("adress", "OK");


        if (managerCases.isUserExists(eMail) || eMail.equals("")) {
            req.getSession(true).setAttribute("email", "Error");
            add = false;
        } else {
            req.getSession(true).setAttribute("email", "OK");
        }


        if (add == true) managerCases.addUserToBase(name, secondName,
                birthdayDate, passport, adress, eMail, managerCases.passwordGenerator(5));

    }
}
