package operator.servlets.user;

import operator.entities.Contract;
import operator.entities.TariffOption;
import operator.entities.User;
import operator.services.implementation.ContractServiceImpl;
import operator.services.implementation.TariffOptionServiceImpl;
import operator.services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Karnov on 9/2/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Servlet for controlling tariff option page
 */
public class TariffOptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();

        String eMail = (String) req.getSession(true).getAttribute("eMail");
        User user = userService.getUserByEMAil(eMail);
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());

        req.getSession(true).setAttribute("user", user);
        req.getSession(true).setAttribute("contracts", contracts);
        req.getSession(true).setAttribute("tariffOptions", tariffOptionService.getAll());
        req.getRequestDispatcher("/WEB-INF/user/userTariffOptions.jsp").forward(req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractServiceImpl contractService = new ContractServiceImpl();
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();

        String contractNumber = req.getParameter("contractNumber");
        int tariffId = Integer.parseInt(req.getParameter("tariff"));
        String method = req.getParameter("method");

        TariffOption tariffOption = tariffOptionService.getEntityById(tariffId);
        Contract contract = contractService.getContractByNumber(contractNumber);

        if (method.equals("unable")) {
            List<TariffOption> jointOptions = new ArrayList();

            boolean isForbid = false;
            for (TariffOption tar : contract.getTariffOptions()) {
                if (tar.getimpossibleTogether().contains(tariffOption))
                    isForbid = true;
            }

            if (!isForbid) {
                jointOptions = tariffOption.getjointTogether();
                for (TariffOption tar : jointOptions) {
                    contract.getTariffOptions().add(tar);
                    contractService.updateEntity(contract);
                }
                contract.getTariffOptions().add(tariffOption);
                contractService.updateEntity(contract);
            } else {
                resp.setStatus(500);
            }
        } else {
            contract.getTariffOptions().remove(tariffOption);
            contractService.updateEntity(contract);
        }
    }
}
