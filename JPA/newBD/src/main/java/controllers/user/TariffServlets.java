package controllers.user;

import controllers.usersCases.UserCases;
import entities.Contract;
import entities.Tariff;
import entities.User;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.TariffServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
    private UserCases userCases = new UserCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getting cookies
        String eMail = userCases.getCookiesValue(req, "eMail");
        String userName = userCases.getCookiesValue(req, "userName");
        req.setAttribute("userName", userName);
        //work with tariff
        req.setAttribute("contracts", userCases.getAllContractsForUser(eMail));
        TariffServiceImpl tariffService = new TariffServiceImpl();
        req.setAttribute("tariffService", tariffService);
        req.getRequestDispatcher("/WEB-INF/user/Tariffs.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post");
        ContractServiceImpl contractService = new ContractServiceImpl();
        TariffServiceImpl tariffService = new TariffServiceImpl();
        int tariffId = Integer.parseInt(req.getParameter("tariffId"));
        Contract contract = contractService.getContractByNumber(req.getParameter("contractNumber"));
        Tariff tariff = tariffService.getEntityById(tariffId);
        contract.setTariff(tariff);
        contractService.updateEntity(contract);

    }
}
