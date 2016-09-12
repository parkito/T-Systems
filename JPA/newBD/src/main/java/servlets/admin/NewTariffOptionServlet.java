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
public class NewTariffOptionServlet extends HttpServlet {
    ManagerCases managerCases = new ManagerCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/NewOption.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean add = true;
        String title = req.getParameter("title");
        String price = req.getParameter("price");
        String connectionPrice = req.getParameter("connectPrice");
        if (title.equals("") || managerCases.isOptionExists(title)) {
            req.getSession(true).setAttribute("titleStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("titleStat", "OK");

        if (price.equals("")) {
            req.getSession(true).setAttribute("priceStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("priceStat", "OK");

        if (connectionPrice.equals("")) {
            req.getSession(true).setAttribute("connectionPriceStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("connectionPriceStat", "OK");

        if (add == true) managerCases.addOptionToBase(title, price,connectionPrice);
    }
}
