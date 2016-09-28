
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
import operator.services.implementation.TariffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/userContract", method = RequestMethod.GET)
    public String contracts(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        return "user/userContract";
    }

    // TODO: 9/27/16 анот для юзеров
    @RequestMapping(value = "/userTariffs", method = RequestMethod.GET)
    public String tariffs(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        model.addAttribute("allTariffs", tariffService.getAll());
        model.addAttribute("tempId", new ArrayList<Integer>());
        return "user/userTariffs";
    }

    @RequestMapping(value = "/userChangeTariff", method = RequestMethod.POST)
    public String changeTariff(HttpServletRequest request, Locale locale, Model model,
                               @RequestParam(value = "tariffId") String tariffId,
                               @RequestParam(value = "contractNumber") String contractNumber) {
        int tariffID = Integer.valueOf(tariffId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        Tariff tariff = tariffService.getEntityById(tariffID);
        contract.setTariff(tariff);
        contractService.updateEntity(contract);
        return "user/userTariffs";
    }

    @RequestMapping(value = "/userTariffOptions", method = RequestMethod.GET)
    public String tariffOptions(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        model.addAttribute("allTariffOptions", optionService.getAll());
        return "user/userTariffOptions";
    }

    // TODO: 9/28/16 тут случаются глюки. Быть осторожным 
    @RequestMapping(value = "/userChangeTariffOptions", method = RequestMethod.GET)
    public String chgangeTariffOptions(HttpServletRequest request, HttpServletResponse resp, Locale locale, Model model,
                                       @RequestParam(value = "contractNumber") String contractNumber,
                                       @RequestParam(value = "tariffOptionId") String tariffOptionId,
                                       @RequestParam(value = "method") String method) {
        User user = (User) request.getSession().getAttribute("currentUser");
        int tariffOptionID = Integer.parseInt(tariffOptionId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        TariffOption tariffOption = optionService.getEntityById(tariffOptionID);
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
                resp.setStatus(430);
            }
        } else {
            contract.getTariffOptions().remove(tariffOption);
            contractService.updateEntity(contract);
        }
        return "user/userTariffOptions";
    }

}

