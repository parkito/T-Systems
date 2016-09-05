package controllers.user;

import controllers.UserCases;
import services.implementation.TariffOptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        req.getSession(true).setAttribute("userName", userName);
        req.setAttribute("userName", userName);
        //work with contract
        req.getSession(true).setAttribute("contracts", userCases.getAllContractsForUser(eMail));
        req.setAttribute("contracts", userCases.getAllContractsForUser(eMail));
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.getSession(true).setAttribute("tariffOptionService", tariffOptionService);
        req.setAttribute("tariffOptionService", tariffOptionService);
        req.getRequestDispatcher("/WEB-INF/user/Contract.jsp").forward(req, resp);
    }


}
