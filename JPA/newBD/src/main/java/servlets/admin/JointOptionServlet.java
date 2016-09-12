package servlets.admin;

import controllers.ManagerCases;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/9/16.
 * artyom-karnov@yandex.ru
 **/
public class JointOptionServlet extends HttpServlet {
    ManagerCases managerCases = new ManagerCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/JointOption.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean add = true;
        String tariffOne = req.getParameter("tariffOne");
        String tariffTwo = req.getParameter("tariffTwo");
        System.out.println(tariffOne + " " + tariffTwo);

        if (tariffOne.equals("") || !managerCases.isOptionExists(tariffOne)) {
            req.getSession(true).setAttribute("oneStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("oneStat", "OK");

        if (tariffTwo.equals("") || !managerCases.isOptionExists(tariffTwo)) {
            req.getSession(true).setAttribute("twoStat", "Error");
            add = false;
        } else
            req.getSession(true).setAttribute("twoStat", "OK");

        if (add == true) {
            System.out.println("here");
            managerCases.addJoinOptionToBase(tariffOne, tariffTwo);
        }
    }
}
