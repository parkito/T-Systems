
package operator.controllers;

import operator.entities.Contract;
import operator.entities.User;
import operator.integration.ContractValidator;
import operator.services.api.ContractService;
import operator.services.api.TariffOptionService;
import operator.services.api.TariffService;
import operator.services.api.UserService;
import operator.utils.Locale.Translatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * A controllers to dispatch the queries of the clients.
 */
@Controller
public class ClientController {
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
     * This method returns a main page for the user control panel.
     *
     * @param locale locale;
     * @param model  model;
     * @return cp_client_main.jsp
     */
    @RequestMapping(value = "/cp_client_main", method = RequestMethod.GET)
    public String getMainPage(Locale locale, Model model) {
        return "cp_client/cp_client_main";
    }

    /**
     * This method returns a profile page.
     *
     * @param locale locale;
     * @param model  model;
     * @return cp_client_profile.jsp
     */
    @RequestMapping(value = "/cp_client_profile", method = RequestMethod.GET)
    public String getProfile(Locale locale, Model model) {
        return "cp_client/cp_client_profile";
    }

    /**
     * This method returns a page will all the contracts of current user.
     *
     * @param request request;
     * @param locale  locale;
     * @param model   model;
     * @return cp_client_contracts.jsp
     */
    @RequestMapping(value = "/cp_client_contracts", method = RequestMethod.GET)
    public String getContracts(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUserU");
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        return "cp_client/cp_client_contracts";
    }

    /**
     * This method returns a page where the tariff for the contract should be selected.
     *
     * @param contractId the contracts id;
     * @param request    request;
     * @param locale     locale;
     * @param model      model;
     * @return cp_client_change_contract.jsp
     */
    @RequestMapping(value = "/cp_client_change_contract", method = RequestMethod.GET)
    public String changeContract(@RequestParam(value = "contractId") int contractId,
                                 HttpServletRequest request, Locale locale, Model model) {
        Translatable translatable = (Translatable) request.getSession().getAttribute("language");
        Contract contract = contractService.getEntityById(contractId);
        User user = (User) request.getSession().getAttribute("currentUserU");
        if (!user.getContracts().contains(contract)) return "cp_client/cp_client_main";
        if (contract.isBlocked()) {
            return "cp_client/cp_client_main";
        }
        request.getSession().setAttribute("tariffsList", tariffService.getAll());
        request.getSession().setAttribute("contract", contract);
        /*request.getSession().setAttribute("contractNumber", contract.getNumber());*/
        return "cp_client/cp_client_change_contract";
    }

    /**
     * This method:
     * - blocks a contract, if it is not blocked;
     * - unblocks a contract, if it had been blocked by user;
     * - doesn't allow to do any actions, if it has been blocked by employee.
     *
     * @param number  contracts number;
     * @param request request;
     * @param locale  locale;
     * @param model   model;
     * @return cp_client_change_contract.jsp
     */
    @RequestMapping(value = "/cp_client_block_contract", method = RequestMethod.GET)
    public String blockContract(@RequestParam(value = "contractId") int number,
                                HttpServletRequest request, Locale locale, Model model) {
        Translatable translatable = (Translatable) request.getSession().getAttribute("language");
        Contract contract = contractService.getEntityById(number);
        User user = (User) request.getSession().getAttribute("currentUserU");
        if (!user.getContracts().contains(contract)) return "cp_client/cp_client_main";
        if (contract.isBlocked()) {
            if (contract.getUser() == null) {
                contract.setBlocked(false);
                contractService.updateEntity(contract);
                request.getSession().setAttribute("paramIsBlocked", translatable.getJSP_CONTRACTS_UNBLOCKED());
                request.getSession().setAttribute("action", translatable.getJSP_CONTRACTS_BLOCK());
                request.getSession().setAttribute("contract", contract);
            }
        } else {
            contract.setBlocked(true);
            contractService.updateEntity(contract);
            request.getSession().setAttribute("paramIsBlocked", translatable.getJSP_CONTRACTS_BLOCKED());
            request.getSession().setAttribute("action", translatable.getJSP_CONTRACTS_UNBLOCK());
            request.getSession().setAttribute("contract", contract);
        }
        model.addAttribute("contractsUserList", contractService.getAllContractsForUser(user.getUserId()));
        return "cp_client/cp_client_contracts";
    }


    /**
     * This method returns a page with a bucket with selected options, if the entered data is valid, and redirects back to the page with options otherwise.
     * The array with options' id is validated by a contractValidator. If something is incorrect, the exception is
     * added to the exceptionsList.
     *
     * @param array   the array of options' ids;
     * @param request request;
     * @param locale  locale;
     * @param model   model;
     * @return cp_client_contract_change_bucket.jsp or exception.jsp
     */
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/cp_client_contract_bucket", method = RequestMethod.POST)
//    public String finalContractChange(@RequestParam(value = "cb") int tariffId,
//                                      @RequestParam(value = "cb3", required = false) int[] array,
//                                      HttpServletRequest request, Locale locale, Model model) throws Exception {
//        if (((Contract) request.getSession().getAttribute("contract")).isBlocked()) {
//            return "cp_client/cp_client_main";
//        }
//        User user = (User) request.getSession().getAttribute("currentUserU");
//        TariffOption tariffOption = tariffService.getEntityById(tariffId);
//        Contract contract = (Contract) request.getSession().getAttribute("contract");
//        contract.set(tariffOption);
//        if (array == null || array.length == 0) {
//            contract.removeAllOptions();
//            request.getSession().setAttribute("updatedContract", contract);
//            model.addAttribute("optionsList", contract.getOptions());
//            request.getSession().setAttribute("totalAmount", 0);
//            return "cp_client/cp_client_contract_change_bucket";
//        } else {
//            List<Exception> exceptionList = new ArrayList<>();
//            List validationResultList = contractValidator.validateOptions(array, exceptionList, user.getId()); //checking if the entered options are correct
//            List<Option> optionList = (List<Option>) validationResultList.get(0);
//            exceptionList = (List<Exception>) validationResultList.get(1);
//            if (exceptionList.isEmpty()) {
//                contract.removeAllOptions();
//                for (Option x : optionList) {
//                    contract.addOption(x);
//                }
//                //the amount to decrease
//                request.getSession().setAttribute("totalAmount", user.getBalance() - contractValidator.balanceCheck(user.getId(), optionList));
//                request.getSession().setAttribute("updatedContract", contract);
//                model.addAttribute("optionsList", contract.getOptions());
//                return "cp_client/cp_client_contract_change_bucket";
//            } else {
//                throw new Exception("jQuery required to perform this operation!");
//            }
//        }
//
//
//    }

    /**
     * This method finally changes the contract after the approval by the client.
     *
     * @param request request;
     * @param locale  locale;
     * @param model   model;
     * @return success.jsp
     */
    @RequestMapping(value = "/cp_client_bucket_approved", method = RequestMethod.POST)
    public String approveBucket(HttpServletRequest request, Locale locale, Model model) {
        Contract contract = (Contract) request.getSession().getAttribute("updatedContract");
        User user = (User) request.getSession().getAttribute("currentUserU");
        contractService.updateEntity(contract);
        //balance decreased
        user.setBalance(user.getBalance() - (Integer) request.getSession().getAttribute("totalAmount"));
        userService.updateEntity(user);
        return "cp_client/success";
    }

    /**
     * This method returns a page where you can increase the current balance.
     *
     * @param locale locale;
     * @param model  model;
     * @return cp_client_balance
     */
    @RequestMapping(value = "/cp_client_balance", method = RequestMethod.GET)
    public String getBalance(Locale locale, Model model) {
        return "cp_client/cp_client_balance";
    }

    /**
     * This method increases the current balance by 100.
     *
     * @param request request;
     * @param locale  locale;
     * @param model   model;
     * @return cp_client_balance.jsp
     */
    @RequestMapping(value = "/cp_client_increase_balance", method = RequestMethod.GET)
    public String increaseBalance(HttpServletRequest request, Locale locale, Model model) {
        User user = (User) request.getSession().getAttribute("currentUserU");
        user.setBalance(user.getBalance() + 100);
        userService.updateEntity(user);
        request.getSession().setAttribute("currentUserU", user);
        return "cp_client/cp_client_balance";
    }
}

