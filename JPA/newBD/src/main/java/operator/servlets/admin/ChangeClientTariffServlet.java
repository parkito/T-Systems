package operator.servlets.admin;

import operator.entities.Contract;
import operator.entities.User;
import operator.services.implementation.ContractServiceImpl;
import operator.services.implementation.TariffServiceImpl;
import operator.services.implementation.UserServiceImpl;

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

/**
 * Servlet for controlling changing client's  tariffs
 */
public class ChangeClientTariffServlet extends HttpServlet {
    public static int count = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (count == 1) {
            req.getSession(true).setAttribute("check", "start");
            count++;
        }
        ContractServiceImpl contractService = new ContractServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        TariffServiceImpl tariffService = new TariffServiceImpl();

        String eMail = (String) req.getSession(true).getAttribute("eMail");
        String userName = (String) req.getSession(true).getAttribute("userName");
        User user = userService.getUserByEMAil(eMail);
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());

        req.getSession(true).setAttribute("contracts", contracts);
        req.getSession().setAttribute("tariffService", tariffService);
        req.getRequestDispatcher("/WEB-INF/admin/adminChangeClientTariff.jsp").forward(req, resp);

    }
}
