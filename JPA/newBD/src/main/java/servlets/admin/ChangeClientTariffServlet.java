package servlets.admin;

import entities.Contract;
import entities.User;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffServiceImpl;
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
public class ChangeClientTariffServlet extends HttpServlet {
    public static int count =1;
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

//        req.getSession(true).setAttribute("check", "work");
        req.getSession(true).setAttribute("contracts", contracts);
        req.getSession().setAttribute("tariffService", tariffService);
        req.getRequestDispatcher("/WEB-INF/admin/ChangeClientTariff.jsp").forward(req, resp);

    }
}
