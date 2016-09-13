package servlets.admin;

import controllers.ManagerCases;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/8/16.
 * artyom-karnov@yandex.ru
 **/
/**
 * Servlet for new tariff controlling
 */
public class NewTariffServlet extends HttpServlet {
    private ManagerCases managerCases = new ManagerCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/NewTariff.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean add = true;
        String title = req.getParameter("title");
        String price = req.getParameter("price");
        if (title.equals("") || managerCases.isTariffExists(title)) {
            req.getSession(true).setAttribute("titleStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("titleStat", "OK");

        if (price.equals("")) {
            req.getSession(true).setAttribute("priceStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("priceStat", "OK");

        if (add == true) managerCases.addTariffToBase(title, price);


    }
}

