
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    /**
     * Method for dispatching requests to user's contracts
     *
     * @param request request from page
     * @param locale  locale for page
     * @param model   model for page view
     * @return page for view user's contract
     */

    @RequestMapping(value = "/userContract", method = RequestMethod.GET)
    public String contracts(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        return "user/userContract";
    }

    /**
     * Method for dispatching requests to user's tariffs
     *
     * @param request request from page
     * @param locale  locale for page
     * @param model   model for page view
     * @return page for view user's tariffs
     */

    // TODO: 9/27/16 анот для юзеров
    @RequestMapping(value = "/userTariffs", method = RequestMethod.GET)
    public String tariffs(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        model.addAttribute("allTariffs", tariffService.getAll());
        model.addAttribute("tempId", new ArrayList<Integer>());
        return "user/userTariffs";
    }

    /**
     * Method for dispatching requests to user's user's tariff changing
     *
     * @param request        request from page
     * @param locale         locale for page
     * @param model          model for page view
     * @param tariffId       of of changing tariff
     * @param contractNumber contract number for changing
     * @return page for view tariff changing
     */
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

    /**
     * Method for dispatching requests to user's tariff options changing
     *
     * @param request request from page
     * @param locale  locale for page
     * @param model   model for page view
     * @return page for view options changing
     */
    @RequestMapping(value = "/userTariffOptions", method = RequestMethod.GET)
    public String tariffOptions(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        model.addAttribute("allTariffOptions", optionService.getAll());
        return "user/userTariffOptions";
    }

    /**
     * Method for dispatching requests to user's tariff options changing
     *
     * @param request        request from page
     * @param resp           request to page
     * @param locale         locale for page
     * @param model          model for page view
     * @param contractNumber number for changing
     * @param tariffOptionId tariff option id for changing
     * @param method         method for changing
     * @return page for view user's tariff options changing
     */
    // TODO: 9/28/16 тут случаются глюки. Быть осторожным
    @RequestMapping(value = "/userChangeTariffOptions", method = RequestMethod.DELETE)
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

    /**
     * Method for dispatching requests to user's number operations
     *
     * @param locale locale for page
     * @param model  model for page view
     * @return page for view user's number operations
     */

    @RequestMapping(value = "/userNumberOperations", method = RequestMethod.GET)
    public String userNumberOperations(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("contracts", contractService.getAllContractsForUser(user.getUserId()));
        return "user/userNumberOperations";
    }

    /**
     * Method for dispatching requests to user's number operations
     *
     * @param resp        request to page
     * @param locale      locale for page
     * @param model       model for page view
     * @param unblockItem element for blocking
     * @param blockItem   element for unblocking
     * @return page for view user's number operations
     */
    @RequestMapping(value = "/userNumberOperations", method = RequestMethod.POST)
    public String userNumberOperationsDelete(HttpServletResponse resp, Locale locale, Model model,
                                             @RequestParam(value = "unblockItem") String unblockItem,
                                             @RequestParam(value = "blockItem") String blockItem) {
        System.out.println(unblockItem + " " + blockItem);
        if (blockItem != null) {
            Contract contract = contractService.getContractByNumber(blockItem);
            contract.setBlocked(true);
            contractService.updateEntity(contract);
        }

        if (unblockItem != null) {
            Contract contract = contractService.getContractByNumber(unblockItem);
            if (!contract.getBlockedByAdmin()) {
                contract.setBlocked(false);
                contractService.updateEntity(contract);
            } else {
                resp.setStatus(600);

            }
        }
        return "user/userNumberOperations";
    }
}
