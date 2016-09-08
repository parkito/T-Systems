package controllers.user;

import controllers.UserCases;
import entities.Contract;
import services.implementation.ContractServiceImpl;
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
    private TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = (String) req.getSession(true).getAttribute("eMail");
        req.getSession(false).setAttribute("contracts", userCases.getAllContractsForUser(eMail));
        req.getSession(false).setAttribute("tariffOptionService", tariffOptionService);

        req.getRequestDispatcher("/WEB-INF/user/Contract.jsp").forward(req, resp);
    }

}
