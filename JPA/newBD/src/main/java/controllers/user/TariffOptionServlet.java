package controllers.user;

import controllers.usersCases.UserCases;
import entities.Contract;
import entities.TariffOption;
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
 * Created by Artyom Karnov on 9/2/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 9/4/16 thinking about blocking again 
public class TariffOptionServlet extends HttpServlet {
    private UserCases userCases = new UserCases();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = userCases.getCookiesValue(req, "eMail");
        String userName = userCases.getCookiesValue(req, "userName");
        req.setAttribute("userName", userName);

        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);

        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        req.setAttribute("contracts", contracts);
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.setAttribute("tariffOptions", tariffOptionService.getAll());
        req.getRequestDispatcher("/WEB-INF/user/TariffOptions.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contractNumber = req.getParameter("contractNumber");
        int tariffId = Integer.parseInt(req.getParameter("tariff"));
        String method = req.getParameter("method");
        ContractServiceImpl contractService = new ContractServiceImpl();
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        TariffOption tariffOption = tariffOptionService.getEntityById(tariffId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        System.out.println(tariffId + " " + contractNumber + " " + method);
        if (method.equals("unable")) {
            System.out.println("here");
            contract.getTariffOptions().add(tariffOption);
            contractService.updateEntity(contract);
        } else {
            contract.getTariffOptions().remove(tariffOption);
            contractService.updateEntity(contract);
        }

    }
}
