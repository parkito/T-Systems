package operator.servlets.user;

import operator.entities.Contract;
import operator.entities.User;
import operator.services.implementation.ContractServiceImpl;
import operator.services.implementation.TariffOptionServiceImpl;
import operator.services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        String eMail = (String) req.getSession(true).getAttribute("eMail");
        User user = userService.getUserByEMAil(eMail);
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());

        req.getSession(false).setAttribute("contracts", contracts);
        req.getSession(false).setAttribute("tariffOptionService", tariffOptionService);
        req.getRequestDispatcher("/WEB-INF/user/userContract.jsp").forward(req, resp);
    }

}
