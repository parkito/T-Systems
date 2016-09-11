package controllers.admin;

import entities.Contract;
import entities.User;
import services.implementation.ContractServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Artyom Karnov on 9/11/16.
 * artyom-karnov@yandex.ru
 **/
public class ContractControlServlet extends HttpServlet {
    private static int count = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        if (count == 1) {
            req.getSession(true).setAttribute("check", "start");
            count++;
        }

        String eMail = (String) req.getSession(true).getAttribute("eMail");
        User user = userService.getUserByEMAil(eMail);

        req.getSession(true).setAttribute("userObj", user);
        String userName = user.getName();
        req.getSession(true).setAttribute("userName", userName);

        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        req.getSession(true).setAttribute("contracts", contracts);
        req.getRequestDispatcher("/WEB-INF/admin/ContractControl.jsp").forward(req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        if (req.getParameter("blockItem") != null) {
            Contract contract = contractService.getContractByNumber(req.getParameter("blockItem"));
            contract.setBlocked(true);
            contract.setBlockedByAdmin(true);
            contractService.updateEntity(contract);
        }

        if (req.getParameter("unblockItem") != null) {
            Contract contract = contractService.getContractByNumber(req.getParameter("unblockItem"));
            contract.setBlocked(false);
            contract.setBlockedByAdmin(false);
            contractService.updateEntity(contract);

        }
    }
}
