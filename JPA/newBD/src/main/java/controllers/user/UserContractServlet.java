package controllers.user;

import controllers.usersCases.UserCases;
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
    private UserCases userCases = new UserCases();

    // TODO: 9/2/16 do optimization
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getting cookies
        String userName = userCases.getCookiesValue(req, "userName");
        String eMail = userCases.getCookiesValue(req, "eMail");
        req.setAttribute("userName", userName);
        //work with contract
        req.setAttribute("contracts", userCases.getAllContractsForUser(eMail));
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.setAttribute("tariffOptionService", tariffOptionService);
        req.getRequestDispatcher("/WEB-INF/user/Contract.jsp").forward(req, resp);
    }


}
