package controllers.user;

import entities.Contract;
import entities.User;
import services.implementation.ContractServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Artyom Karnov on 9/1/16.
 * artyom-karnov@yandex.ru
 **/
public class NumberOperationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("eMail")) eMail = cookie.getValue();
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);
        req.setAttribute("userObj", user);
        String userName = user.getName();
        req.setAttribute("userName", userName);
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        req.setAttribute("contracts", contracts);
        req.getRequestDispatcher("/WEB-INF/user/NumberOperations.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();

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
                // TODO: 9/3/16 how invoke window on the page? make it
                req.getRequestDispatcher("/404.jsp");
            }
            contractService.updateEntity(contract);
        }

    }
}
