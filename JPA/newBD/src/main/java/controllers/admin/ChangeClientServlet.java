package controllers.admin;

import entities.Contract;
import entities.User;
import exceptions.ContractNotFoundException;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.TariffServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/
public class ChangeClientServlet extends HttpServlet {
    public static int count = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (count == 1) {
            req.getSession(true).setAttribute("check", "start");
            count++;
        }

        String eMail = (String) req.getSession(true).getAttribute("eMail");
        String userName = (String) req.getSession(true).getAttribute("userName");

        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);

        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        req.getSession(true).setAttribute("contracts", contracts);

        TariffServiceImpl tariffService = new TariffServiceImpl();
        req.getSession().setAttribute("tariffService", tariffService);

        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.getSession(true).setAttribute("tariffOptions", tariffOptionService.getAll());

        req.getRequestDispatcher("/WEB-INF/admin/ChangeClient.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        //------------------------------------------------
        String number = req.getParameter("number");
        req.getSession(true).setAttribute("check", "work");
        try {
            Contract contract = contractService.getContractByNumber(number);
            req.getSession(true).setAttribute("usr", contract);

        } catch (ContractNotFoundException ex) {
            req.getSession(true).setAttribute("usr", null);
        }

        //-----------------------------------------------


        if (req.getParameter("blockItem") != null) {
            Contract contract = contractService.getContractByNumber(req.getParameter("blockItem"));
            contract.setBlocked(true);
            contractService.updateEntity(contract);
        }
        if (req.getParameter("unblockItem") != null) {
            Contract contract = contractService.getContractByNumber(req.getParameter("unblockItem"));
            if (!contract.getBlockedByAdmin())
                contract.setBlocked(false);
            else {
                req.getRequestDispatcher("/404.jsp");
            }
            contractService.updateEntity(contract);
        }
    }
}
