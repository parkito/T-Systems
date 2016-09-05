package controllers.user;

import controllers.UserCases;
import entities.Contract;
import entities.TariffOption;
import entities.User;
import services.implementation.ContractServiceImpl;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
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
        req.getSession(true).setAttribute("contracts", contracts);
        req.setAttribute("contracts", contracts);
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.getSession(true).setAttribute("tariffOptions", tariffOptionService.getAll());
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
        if (method.equals("unable")) {
            contract.getTariffOptions().add(tariffOption);
            contractService.updateEntity(contract);
        } else {
            contract.getTariffOptions().remove(tariffOption);
            contractService.updateEntity(contract);
        }

    }
}
