package controllers.user;

import controllers.UserCases;
import entities.Contract;
import entities.Tariff;
import entities.User;
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
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/4/16 thinking about blocking 
public class TariffServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        TariffServiceImpl tariffService = new TariffServiceImpl();

        String eMail = (String) req.getSession(true).getAttribute("eMail");
        String userName = (String) req.getSession(true).getAttribute("userName");
        User user = userService.getUserByEMAil(eMail);
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());

        req.getSession(true).setAttribute("contracts", contracts);
        req.getSession().setAttribute("tariffService", tariffService);
        req.getRequestDispatcher("/WEB-INF/user/Tariffs.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        TariffServiceImpl tariffService = new TariffServiceImpl();

        int tariffId = Integer.parseInt(req.getParameter("tariffId"));
        Contract contract = contractService.getContractByNumber(req.getParameter("contractNumber"));
        Tariff tariff = tariffService.getEntityById(tariffId);

        contract.setTariff(tariff);
        contractService.updateEntity(contract);

    }
}
