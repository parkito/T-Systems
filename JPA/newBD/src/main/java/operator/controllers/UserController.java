
package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.TariffOption;
import operator.entities.User;
import operator.integration.ContractValidator;
import operator.services.api.ContractService;
import operator.services.api.TariffOptionService;
import operator.services.api.TariffService;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A controllers to dispatch the queries of the clients.
 */
@Controller("ClientController")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private TariffService tariffService;
    @Autowired
    private TariffOptionService optionService;
    @Autowired
    private ContractValidator contractValidator;


    @RequestMapping(value = "/cp_client_contracts", method = RequestMethod.GET)
    public String getContracts(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUserU");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        return "cp_client/cp_client_contracts";
    }

    @RequestMapping(value = "/userContract", method = RequestMethod.GET)
    public String contracts(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        return "user/userContract";
    }

    @RequestMapping(value = "/userTariffs", method = RequestMethod.GET)
    public String tariffs(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        return "user/userTariffs";
    }

    @RequestMapping(value = "/userChangeTariff", method = RequestMethod.POST)
    public String changeTariff(HttpServletRequest request, Locale locale, Model model,
                                @RequestParam(value = "tariffId") int tariffId,
                                @RequestParam(value = "contractNumber") String contractNumber) {

        Contract contract = contractService.getContractByNumber(contractNumber);
        Tariff tariff = tariffService.getEntityById(tariffId);
        contract.setTariff(tariff);
        contractService.updateEntity(contract);
        return "user/userContract";
    }

}

