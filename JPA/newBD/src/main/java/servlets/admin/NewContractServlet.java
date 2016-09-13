package servlets.admin;

import controllers.ManagerCases;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/7/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Servlet for new contract controlling
 */
public class NewContractServlet extends HttpServlet {
    private ManagerCases managerCases = new ManagerCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/NewContract.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean add = true;
        String eMail = req.getParameter("email");
        String number = req.getParameter("number");
        if (!managerCases.isUserExists(eMail) || eMail.equals("")) {
            req.getSession(true).setAttribute("emailStat", "Error");
            add = false;
        } else {
            req.getSession(true).setAttribute("emailStat", "OK");
        }

        if (managerCases.isNumberExists(number) || number.equals("")) {
            req.getSession(true).setAttribute("numberStat", "Error");
            add = false;
        } else {
            req.getSession(true).setAttribute("numberStat", "OK");
        }
        if (add == true) managerCases.addContractToBase(eMail, number);
    }
}
