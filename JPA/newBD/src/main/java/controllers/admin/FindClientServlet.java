package controllers.admin;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get");
        req.getRequestDispatcher("/WEB-INF/admin/FindClient.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post");
        String number = req.getParameter("number");
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            Contract contract = contractService.getContractByNumber(number);
            req.getSession(true).setAttribute("usr", contract);

        } catch (ContractNotFoundException ex) {
            req.getSession(true).setAttribute("check", "error");
        }

    }
}
