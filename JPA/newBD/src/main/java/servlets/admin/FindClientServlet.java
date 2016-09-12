package servlets.admin;

import entities.Contract;
import exceptions.ContractNotFoundException;
import services.implementation.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/5/16.
 * artyom-karnov@yandex.ru
 **/
public class FindClientServlet extends HttpServlet {
    public static int count = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (count == 1) {
            req.getSession(true).setAttribute("check", "start");
            count++;
        }
        req.getRequestDispatcher("/WEB-INF/admin/FindClient.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        req.getSession(true).setAttribute("check", "work");
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            Contract contract = contractService.getContractByNumber(number);
            req.getSession(true).setAttribute("usr", contract);

        } catch (ContractNotFoundException ex) {
            req.getSession(true).setAttribute("usr", null);
        }

    }
}
