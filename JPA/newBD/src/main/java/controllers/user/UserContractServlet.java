package controllers.user;

import entities.Contract;
import entities.User;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/31/16.
 * artyom-karnov@yandex.ru
 **/
public class UserContractServlet extends HttpServlet {
    // TODO: 9/2/16 do optimization
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getting cookies
        String eMail = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("eMail")) eMail = cookie.getValue();
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);
        String userName = user.getName();
        req.setAttribute("userName", userName);

        //work with contract

        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        req.setAttribute("contracts", contracts);
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.setAttribute("tariffOptionService", tariffOptionService);

        req.getRequestDispatcher("/WEB-INF/user/Contract.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
