package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.TariffOption;
import operator.entities.User;
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
    UserCases userCases;

    enum Cat {
        Leopard, Puma, Lion, Tiger, Manul
    }

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
    public String changeTariff(HttpServletRequest req, Locale locale, Model model,
                               @RequestParam(value = "tariffId") String tariffId,
                               @RequestParam(value = "contractNumber") String contractNumber) {
        User user = (User) req.getSession().getAttribute("currentUser");
        int tariffID = Integer.parseInt(tariffId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        Tariff tariff = tariffService.getEntityById(tariffID);
        contract.setTariff(tariff);
        contractService.updateEntity(contract);
        req.getSession().setAttribute("userPayment", userCases.getPaymentInfo(user));
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
    @RequestMapping(value = "/userChangeTariffOptions", method = RequestMethod.POST)
    public String chgangeTariffOptions(HttpServletRequest req, HttpServletResponse resp, Locale locale, Model model,
                                       @RequestParam(value = "contractNumber") String contractNumber,
                                       @RequestParam(value = "tariffOptionId") String tariffOptionId,
                                       @RequestParam(value = "method") String method) {
        User user = (User) req.getSession().getAttribute("currentUser");
        int tariffOptionID = Integer.parseInt(tariffOptionId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        TariffOption tariffOption = optionService.getEntityById(tariffOptionID);
        if ("unable".equals(method)) {
            List<TariffOption> jointOptions;

            boolean isForbiden = false;
            for (TariffOption option : contract.getTariffOptions()) {
                if (option.getimpossibleTogether().contains(tariffOption))
                    isForbiden = true;
            }

            if (!isForbiden) {
                jointOptions = tariffOption.getjointTogether();
                for (TariffOption tar : jointOptions) {
                    contract.getTariffOptions().add(tar);
                    contractService.updateEntity(contract);
                }
                contract.getTariffOptions().add(tariffOption);
                contractService.updateEntity(contract);
            } else {
                resp.addHeader("Access-Control-Allow-Origin", "*");
                resp.addHeader("X-XSS-Protection", "0");
                resp.setStatus(405);
            }
        } else {
            contract.getTariffOptions().remove(tariffOption);
            contractService.updateEntity(contract);
        }
        req.getSession().setAttribute("userPayment", userCases.getPaymentInfo(user));
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
    // TODO: 9/29/16 Оптимизация

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
    public String userNumberOperationsDelete(HttpServletRequest req, HttpServletResponse resp, Locale locale, Model model,
                                             @RequestParam(value = "number") String number,
                                             @RequestParam(value = "status") String status) {
        User user = (User) req.getSession().getAttribute("currentUser");
        model.addAttribute("contracts", contractService.getAllContractsForUser(user.getUserId()));
        String blockItem = null, unblockItem = null;
        if ("block".equals(status))
            blockItem = status;
        else unblockItem = status;
        if (blockItem != null) {
            Contract contract = contractService.getContractByNumber(number);
            contract.setBlocked(true);
            contractService.updateEntity(contract);
        }

        if (unblockItem != null) {
            Contract contract = contractService.getContractByNumber(number);
            if (!contract.getBlockedByAdmin()) {
                contract.setBlocked(false);
                contractService.updateEntity(contract);
            } else {
                resp.addHeader("Access-Control-Allow-Origin", "*");
                resp.addHeader("X-XSS-Protection", "0");
                resp.setStatus(600);
            }
        }
        req.getSession().setAttribute("userPayment", userCases.getPaymentInfo(user));
        return "user/userNumberOperations";
    }

    @RequestMapping(value = "/Help", method = RequestMethod.GET)
    public String help(HttpServletRequest request, Locale locale, Model model) {
        return "Help";
    }
}
