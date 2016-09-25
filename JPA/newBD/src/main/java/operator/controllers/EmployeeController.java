package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.TariffOption;
import operator.entities.User;
import operator.integration.ContractValidator;
import operator.integration.EntityRemoval;
import operator.integration.UserUpdater;
import operator.services.api.ContractService;
import operator.services.api.TariffOptionService;
import operator.services.api.TariffService;
import operator.services.api.UserService;
import operator.utils.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * A controllers to dispatch the queries of the employees.
 */
@Controller
public class EmployeeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private TariffService tariffService;
    @Autowired
    private TariffOptionService optionService;
//    @Autowired
//    private AccessLevel roleService;
    @Autowired
    private ContractValidator contractValidator;
    @Autowired
    private UserUpdater userUpdater;
    @Autowired
    private EntityRemoval entityRemoval;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * This method returns the main employee page.
     * @param locale locale;
     * @param model model;
     * @return cp_employee_main.jsp
     */
    @RequestMapping(value = "/cp_employee_main", method = RequestMethod.GET)
    public String mainPage(Locale locale, Model model) {
        return "cp_employee/cp_employee_main";
    }

    /**
     * This method returns a profile page.
     * @return cp_employee_profile.jsp
     */
    @RequestMapping(value = "/cp_employee_profile", method = RequestMethod.GET)
    public String getProfile() {
        return "cp_employee/cp_employee_profile";
    }

    /**
     * This method resolves a page with all contracts. When contractId is specified, the contract is deleted.
     * @param id the id of the contract;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_contracts.jsp
     */
    @RequestMapping(value = "/cp_employee_contracts", method = RequestMethod.GET)
    public String contractsPage(@RequestParam(value = "contractId", required = false) Integer id,
                                Locale locale, Model model) {
        if (id != null && id != 0) {
            Contract contract = contractService.getEntityById(id);
            User user = userService.getUserByNumber(contract.getNumber());
            contractService.deleteEntity(contract);
        }
        model.addAttribute("contractsList", contractService.getAll());
        return "cp_employee/cp_employee_contracts";
    }

    /**
     * This method returns a page where a new contract is being created. It sets a list with all tariffs to choose from.
     * If the id is specified, the login of the user will be added to the page.
     * @param id the id of the user;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_new_contract.jsp
     */
    @RequestMapping(value = "/cp_employee_new_contract", method = RequestMethod.GET)
    public String addContract(@RequestParam(value = "id", required = false) Integer id, Locale locale, Model model) {
        if (id != null) {
            model.addAttribute("currentLogin", userService.getEntityById(id).getEmail());
        }
        model.addAttribute("tariffsList", tariffService.getAll());
        return "cp_employee/cp_employee_new_contract";
    }



    /** This method creates a contract, if the entered data is valid, and redirects back to the page with options otherwise.
     * The array with options' id is validated by a contractValidator. If something is incorrect, the exception is
     * added to the exceptionsList.
     *
     * @param contractNumber a number of the contract;
     * @param tariffId the tariff id;
     * @param array the array of selected options' ids;
     * @param locale locale
     * @param model model
     * @return success.jsp
     */
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/cp_employee_contract_created", method = RequestMethod.POST)
//    public String createContract(@RequestParam(value = "login") String login,
//                                 @RequestParam(value = "number") String contractNumber,
//                                 @RequestParam(value = "cb") int tariffId,
//                                 @RequestParam(value = "cb3", required = false) int[] array,
//                                 Locale locale, Model model) throws Exception{
//        User user = userService.getUserByEMAil(login);
//        long number = Long.parseLong(Parser.doParse(contractNumber));
//        Tariff tariffOption = tariffService.getEntityById(tariffId);
//        Contract contract = new Contract(number, user, tariffOption);
//        if (array == null || array.length == 0)  {
//            contractService.createEntity(contract);
//            user.addContract(contract);
//            userService.updateEntity(user);
//            return "cp_employee/success";
//        }
//        else {
//            List<Exception> exceptionList = new ArrayList<>();
//            List validationResultList = contractValidator.validateOptions(array, exceptionList, 0); //checking if the entered options are correct
//            List<TriffOption> optionList = (List<TriffOption>) validationResultList.get(0);
//            exceptionList = (List<Exception>) validationResultList.get(1);
//            if (exceptionList.isEmpty()) {
//                for (TriffOption x : optionList) {
//                    contract.addOption(x);
//                }
//                contractService.createEntity(contract);
//                user.addContract(contract);
//                userService.updateEntity(user);
//                return "cp_employee/success";
//            }
//            else {
//                throw new Exception("jQuery required for performing the action!");
//            }
//        }
//
//    }

    /**
     * This method blocks or unblocks a contract.
     * @param contractId the ID of the contract;
     * @param request request;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_contracts.jsp
     */
//    @RequestMapping(value = "/cp_employee_block_contract", method = RequestMethod.GET)
//    public String blockContract(@RequestParam(value = "contractId") Integer contractId,
//                                HttpServletRequest request, Locale locale, Model model) {
//        Contract contract = contractService.getEntityById(contractId);
//        if (contract.isBlocked()) {
//            contract.setBlocked(!contract.isBlocked());
//            contract.setEmployee(null);
//        }
//        else {
//            contract.setBlocked(!contract.isBlocked());
//            contract.setEmployee((User) request.getSession().getAttribute("currentUserU"));
//        }
//        contractService.updateEntity(contract);
//        model.addAttribute("contractsList", contractService.getAll());
//        return "cp_employee/cp_employee_contracts";
//    }

    /**
     * This method returns a page where you change the contract.
     * If the number of contract is specified in the request, the contract gets blocked / unblocked.
     * @param contractId the ID of the contract;
     * @param contractNumber the number of the contract;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_change_contract.jsp
     */
//    @RequestMapping(value = "/cp_employee_change_contract", method = RequestMethod.GET)
//    public String changeContract(@RequestParam(value = "contractId") Integer contractId,
//                                 @RequestParam(value = "contractNumber", required = false) Long contractNumber,
//                                 HttpServletRequest request, Locale locale, Model model) {
//        Contract contract = contractService.getEntityById(contractId);
//        if (contractNumber != null) {
//            if (contract.isBlocked()) {
//                contract.setBlocked(!contract.isBlocked());
//                contract.setEmployee(null);
//            }
//            else {
//                contract.setBlocked(!contract.isBlocked());
//                contract.setEmployee((User) request.getSession().getAttribute("currentUserU"));
//            }
//            contractService.updateEntity(contract);
//        }
//        if (contract.isBlocked()) {
//            model.addAttribute("paramIsBlocked", "ВКЛЮЧЕНА");
//            model.addAttribute("action", "Разблокировать");
//        }
//        else {
//            model.addAttribute("paramIsBlocked", "выключена");
//            model.addAttribute("action", "Заблокировать");
//        }
//        request.getSession().setAttribute("contractNumber", contract.getNumber());
//        request.getSession().setAttribute("login", contract.getUser().getLogin());
//        model.addAttribute("tariffsList", tariffService.getAll());
//        model.addAttribute("number", contract.getNumber());
//        model.addAttribute("login", contract.getUser().getLogin());
//        model.addAttribute("contractId", contractId);
//        return "cp_employee/cp_employee_change_contract";
//    }



    /** This method changes a contract, if the entered data is valid, and redirects back to the page with options otherwise.
     * The array with options' id is validated by a contractValidator. If something is incorrect, the exception is
     * added to the exceptionsList.
     * @param array the array of selected options' ids;
     * @param request request
     * @param locale locale
     * @param model model
     * @return success.jsp or exception.jsp
     */
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/cp_employee_contract_changed", method = RequestMethod.POST)
//    public String finalContractChange(  @RequestParam(value = "cb") Integer tariffId,
//                                        @RequestParam(value = "cb3", required = false) int[] array,
//                                        HttpServletRequest request, Locale locale, Model model) throws Exception{
//        TariffOption tariffOption = tariffService.getEntityById(tariffId);
//        long number = (long) request.getSession().getAttribute("contractNumber");
//        Contract contract = contractService.getContractByNumber(number);
//        contract.setTariffOption(tariffOption);
//        if (array == null || array.length == 0) {
//            contract.removeAllOptions();
//            contractService.updateEntity(contract);
//            return "cp_employee/success";
//        }
//        else {
//            List<Exception> exceptionList = new ArrayList<>();
//            List validationResultList = contractValidator.validateOptions(array, exceptionList, 0); //checking if the entered options are correct
//            List<Option> optionList = (List<Option>) validationResultList.get(0);
//            exceptionList = (List<Exception>) validationResultList.get(1);
//            if (exceptionList.isEmpty()) {
//                contract.removeAllOptions();
//                for (Option x : optionList) {
//                    contract.addOption(x);
//                }
//                contractService.updateEntity(contract);
//                return "cp_employee/success";
//            }
//            else {
//                throw new Exception("jQuery required to perform this operation!");
//            }
//        }
//
//    }

    /**
     * This method returns a page with all users.
     * @param locale locale
     * @param model model
     * @return cp_employee_users.jsp
     */
    @RequestMapping(value = "/cp_employee_users", method = RequestMethod.GET)
    public String getAllUsers(Locale locale, Model model) {
        model.addAttribute("usersList", userService.getAll());
        return "cp_employee/cp_employee_users";
    }

    /**
     * This method adds 100 to current balance.
     * @param id user's id
     * @param locale locale
     * @param model model
     * @return cp_employee_users.jsp
     */
    @RequestMapping(value = "/cp_employee_user_add_balance", method = RequestMethod.GET)
    public String addBalance(@RequestParam(value = "id") int id,
                             Locale locale, Model model) {
        User user = userService.getEntityById(id);
        user.setBalance(user.getBalance() + 100);
        userService.updateEntity(user);
        model.addAttribute("usersList", userService.getAll());
        return "cp_employee/cp_employee_users";
    }

    /**
     * This method returns a page where users' data can be changed.
     * @param id user's id
     * @param locale locale
     * @param model model
     * @return cp_employee_user_data_change.jsp
     */
//    @RequestMapping(value = "cp_employee_user_data_change", method = RequestMethod.GET)
//    public String changeUser(@RequestParam(value = "id") int id,
//                             Locale locale, Model model) {
//        User user = userService.getEntityById(id);
//        model.addAttribute("id", user.getId());
//        model.addAttribute("name", user.getName());
//        model.addAttribute("surname", user.getSurname());
//        model.addAttribute("birthday", dateFormat.format(user.getBirthdayDate()));
//        model.addAttribute("passport", user.getPassport());
//        model.addAttribute("address", user.getAddress());
//        model.addAttribute("email", user.getEmail());
//        model.addAttribute("login", user.getLogin());
//        model.addAttribute("balance", user.getBalance());
//        model.addAttribute("role", user.getRole().getId());
//        return "cp_employee/cp_employee_user_data_change";
//    }

    /**
     * This method deletes a user.
     * @param id user's id
     * @param locale locale
     * @param model model
     * @return cp_employee_users.jsp
     */
//    @RequestMapping(value = "cp_employee_user_delete", method = RequestMethod.GET)
//    public String deleteUser(@RequestParam(value = "id") int id,
//                             Locale locale, Model model) {
//        //добавить проверку, если есть контракты - не удалять!
//        User user = userService.getEntityById(id);
//        if (!contractService.getAllContractsForUser(id).isEmpty())
//        {
//            throw new EntityNotDeletedException("Unable to delete user, you need to remove his contracts first!");
//        }
//        else {
//            userService.deleteEntity(user);
//            model.addAttribute("usersList", userService.getAll());
//            return "cp_employee/cp_employee_users";
//        }
//    }

    /**
     * This method creates a new user. The userUpdater bean is responsible for validating the entered data.
     * @param name user's name
     * @param surname user's surname
     * @param birthday user's birthday
     * @param passport user's passport
     * @param address user's address
     * @param email user's email
     * @param login user's login
     * @param balance user's balance
     * @param password user's password
     * @param roleId user's roleId
     * @param locale locale
     * @param model model
     * @return cp_employee_users.jsp
     * @throws Exception
     */
//    @RequestMapping(value = "cp_employee_create_user", method = RequestMethod.POST)
//    public String createUser(@RequestParam(value = "name") String name,
//                             @RequestParam(value = "surname") String surname,
//                             @RequestParam(value = "birthday") String birthday,
//                             @RequestParam(value = "passport", required = false) String passport,
//                             @RequestParam(value = "address", required = false) String address,
//                             @RequestParam(value = "email", required = false) String email,
//                             @RequestParam(value = "login") String login,
//                             //добавить валидацию баланса
//                             @RequestParam(value = "balance", required = false) Integer balance,
//                             @RequestParam(value = "password") String password,
//                             @RequestParam(value = "cb") int roleId,
//                             Locale locale, Model model) throws Exception{
//
//        User user = userUpdater.createUser(name, surname, birthday, passport, address, email, balance, login, password, roleId);
//        userService.createEntity(user);
//        return "redirect:/cp_employee_users";
//    }

    /**
     * This method updates a user. The userUpdater bean is responsible for validating the entered data.
     * @param id user's id
     * @param name user's name
     * @param surname user's surname
     * @param birthday user's birthday
     * @param passport user's passport
     * @param address user's address
     * @param email user's email
     * @param balance user's balance
     * @param password user's password
     * @param locale locale
     * @param model model
     * @return success.jsp
     * @throws Exception
     */
//    @RequestMapping(value = "cp_employee_change_user", method = RequestMethod.POST)
//    public String updateUser(@RequestParam(value = "id") int id,
//                             @RequestParam(value = "name") String name,
//                             @RequestParam(value = "surname") String surname,
//                             @RequestParam(value = "birthday") String birthday,
//                             @RequestParam(value = "passport", required = false) String passport,
//                             @RequestParam(value = "address", required = false) String address,
//                             @RequestParam(value = "email", required = false) String email,
//                             @RequestParam(value = "balance", required = false) Integer balance,
//                             @RequestParam(value = "password") String password,
//                             Locale locale, Model model) throws Exception{
//        User user = userUpdater.updateUser(id, name, surname, birthday, passport, address, email, balance, password);
//        userService.updateEntity(user);
//        return "cp_employee/success";
//    }

    /**
     * This method redirects to a page for user searching.
     * @param locale locale
     * @param model model
     * @return cp_employee_user_search.jsp
     */
    @RequestMapping(value = "cp_employee_user_search", method = RequestMethod.GET)
    public String searchForUser(Locale locale, Model model) {
        return "cp_employee/cp_employee_user_search";
    }

    /**
     * This method searches for a user. It redirects to a page where user can be changed, if the user is found, and back otherwise.
     * @param number user's contract number
     * @param login user's login
     * @param locale locale
     * @param model model
     * @return cp_employee_user_data_change.jsp or cp_employee_user_search.jsp
     */
//    @RequestMapping(value = "cp_employee_find_user", method = RequestMethod.POST)
//    public String doSearch(@RequestParam(value = "number", required = false) String number,
//                           @RequestParam(value = "login", required = false) String login,
//                           Locale locale, Model model) {
//        User user;
//        try {
//            if (number == null || number.equals("")) {
//                user = userService.getUserByLogin(login);
//            }
//            else {
//                long userNumber = Long.parseLong(Parser.doParse(number));
//                user = userService.getUserByNumber(userNumber);
//            }
//
//            model.addAttribute("id", user.getId());
//            return "redirect:/cp_employee_user_data_change";
//        }
//        catch (Exception ex) {
//            model.addAttribute("found", "false");
//            return "cp_employee/cp_employee_user_search";
//        }
//    }

    /**
     * This method resolves a page with all tariffs.
     * @param locale locale
     * @param model model
     * @return cp_employee_tariffs.jsp
     */
    @RequestMapping(value = "cp_employee_tariffs", method = RequestMethod.GET)
    public String getTariffs(Locale locale, Model model) {
        model.addAttribute("tariffsList", tariffService.getAll());
        model.addAttribute("optionsList", optionService.getAll());
        return "cp_employee/cp_employee_tariffs";
    }

    /**
     * This method creates a new tariff with the specified params.
     * @param name tariff's name;
     * @param price tariff's price;
     * @param array the array of selected options' ids;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_tariffs.jsp
     */
//    @RequestMapping(value = "cp_employee_create_tariff", method = RequestMethod.POST)
//    public String createNewTariff(@RequestParam(value = "name") String name,
//                                  @RequestParam(value = "price") int price,
//                                  @RequestParam(value = "cb", required = false) int[] array,
//                                  Locale locale, Model model) throws Exception{
//        contractValidator.priceCheck(price, "price");
//        TariffOption tariffOption = new TariffOption(name, price);
//        if (null != array && array.length > 0) {
//            for (int optionId : array) {
//                tariffOption.addPossibleOption(optionService.getEntityById(optionId));
//            }
//        }
//        tariffService.createEntity(tariffOption);
//        return "redirect:/cp_employee_tariffs";
//    }

    /**
     * This method returns a page where the tariff can be changed.
     * @param tariffId the tariff id;
     * @param request request;     *
     * @param locale locale;
     * @param model model;
     * @return cp_employee_change_tariff.jsp
     */
//    @RequestMapping(value = "cp_employee_change_tariff", method = RequestMethod.GET)
//    public String changeTariff(@RequestParam(value = "id") int tariffId,
//                               HttpServletRequest request, Locale locale, Model model) {
//        TariffOption tariffOption = tariffService.getEntityById(tariffId);
//        List<Option> allOptionsList = optionService.getAll();
//        List<Option> currentTariffOptionsList = optionService.getAllOptionsForTariff(tariffId);
//        allOptionsList.removeAll(currentTariffOptionsList);
//        model.addAttribute("id", tariffOption.getId());
//        model.addAttribute("currentOptionsList", currentTariffOptionsList);
//        model.addAttribute("allOptionsList", allOptionsList);
//        request.getSession().setAttribute("tariff", tariffOption);
//        /*model.addAttribute("name", tariffOption.getName());
//        model.addAttribute("price", tariffOption.getPrice());*/
//        return "cp_employee/cp_employee_change_tariff";
//    }

    /**
     * This method changes the tariff's data.
     * @param tariffId the tariff id;
     * @param name the tariff's name;
     * @param price the tariff's price;
     * @param array the array of selected options' ids;
     * @param locale locale;
     * @param model model;
     * @return success.jsp
     */
//    @RequestMapping(value = "cp_employee_tariff_final_change", method = RequestMethod.POST)
//    public String finalChangeTariff(@RequestParam(value = "id") int tariffId,
//                                    @RequestParam(value = "name") String name,
//                                    @RequestParam(value = "price") int price,
//                                    @RequestParam(value = "cb", required = false) int[] array,
//                                    Locale locale, Model model) throws Exception{
//        contractValidator.priceCheck(price, "price");
//        TariffOption tariffOption = tariffService.getEntityById(tariffId);
//        tariffOption.removePossibleOptions();
//        if (null != array && array.length > 0) {
//            for (int optionId : array) {
//                tariffOption.addPossibleOption(optionService.getEntityById(optionId));
//            }
//        }
//        tariffOption.setName(name);
//        tariffOption.setPrice(price);
//        tariffService.updateEntity(tariffOption);
//        return "cp_employee/success";
//    }

    /**
     * This method deletes a tariff with the help of entityRemoval service.
     * @param tariffId the tariff id;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_tariffs.jsp
     */
//    @RequestMapping(value = "cp_employee_delete_tariff", method = RequestMethod.GET)
//    public String deleteTariff(@RequestParam(value = "id") int tariffId,
//                               Locale locale, Model model) {
//        if(tariffId == 11) {
//            throw new EntityNotDeletedException("This tariff can not be deleted, some serious business logic is based upon it!");
//        }
//        else {
//            entityRemoval.removeTariff(tariffId);
//            model.addAttribute("tariffsList", tariffService.getAll());
//            return "cp_employee/cp_employee_tariffs";
//        }
//    }

    /**
     * This method returns a page with all options where you can create a new one or change the existing ones.
     * @param locale locale;
     * @param model model;
     * @return cp_employee_options.jsp
     */
    @RequestMapping(value = "cp_employee_options", method = RequestMethod.GET)
    public String getAllOptions(Locale locale, Model model) {
        model.addAttribute("optionsList", optionService.getAll());
        return "cp_employee/cp_employee_options";
    }

    /**
     * This method creates a new option with a list of optionsTogether and optionsIncompatible, if any.
     * @param name option's name;
     * @param price option's price;
     * @param initialPrice option's initialPrice;
     * @param optionsTogether an array of option's ids that will be necessary for current option;
     * @param optionsIncompatible an array of option's ids that will be incompatible for current option;
     * @param locale locale;
     * @param model model;
     * @return success.jsp
     */
//    @RequestMapping(value = "cp_employee_option_created", method = RequestMethod.POST)
//    public String finalCreateOption(@RequestParam(value = "name") String name,
//                                    @RequestParam(value = "price") int price,
//                                    @RequestParam(value = "initialPrice") int initialPrice,
//                                    @RequestParam(value = "cb", required = false) int[] optionsTogether,
//                                    @RequestParam(value = "cb2", required = false) int[] optionsIncompatible,
//                                    Locale locale, Model model) throws Exception{
//        contractValidator.priceCheck(price, "price");
//        contractValidator.priceCheck(initialPrice, "initialPrice");
//        Option option = new Option(name, price, initialPrice);
//        //add a check here if two options were selected incorrectly
//        if (null != optionsTogether && optionsTogether.length > 0) {
//            for (int optionId : optionsTogether) {
//                option.addOptionsTogether(optionService.getEntityById(optionId));
//            }
//        }
//        if (null != optionsIncompatible && optionsIncompatible.length > 0) {
//            for (int optionId : optionsIncompatible) {
//                option.addOptionsIncompatible(optionService.getEntityById(optionId));
//            }
//        }
//        for (Option x : option.getOptionsTogether()) {
//            if (option.getOptionsIncompatible().contains(x)) {
//                throw new Exception("jQuery required to perform this operation!");
//            }
//        }
//        optionService.createEntity(option);
//        return "redirect:/cp_employee_options";
//    }

    /**
     * This method returns a page where an option can be modified. It sets 4 lists to the model:
     * - the list of options which are currently necessary for the option;
     * - the list of options which are not necessary for the option, but can be selected as necessary;
     * - the list of options which are currently incompatible with the option;
     * - the list of options which are not incompatible, but can be selected as incompatible.
     * @param optionId option's id;
     * @param request request;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_change_option.jsp
     */
//    @RequestMapping(value = "cp_employee_change_option", method = RequestMethod.GET)
//    public String changeOption(@RequestParam(value = "optionId") int optionId,
//                               HttpServletRequest request, Locale locale, Model model) {
//        Option option = optionService.getEntityById(optionId);
//        List<Option> optionsListAllIncompatible = new ArrayList<>();
//        List<Option> optionsListAllTogether = optionService.getAll();
//        optionsListAllIncompatible.addAll(optionsListAllTogether);
//        List<Option> optionsTogether = option.getOptionsTogether(); // a list of options together, checked
//        optionsListAllTogether.removeAll(optionsTogether); // a list of other options together, unchecked
//        optionsListAllTogether.remove(option);
//        List<Option> optionsIncompatible = option.getOptionsIncompatible(); // a list of incompatible options, checked
//        optionsListAllIncompatible.removeAll(optionsIncompatible); // and unchecked
//        optionsListAllIncompatible.remove(option);
//        request.getSession().setAttribute("option", option);
//        model.addAttribute("optionsTogether", optionsTogether);
//        model.addAttribute("optionsListAllTogether", optionsListAllTogether);
//        model.addAttribute("optionsIncompatible", optionsIncompatible);
//        model.addAttribute("optionsListAllIncompatible", optionsListAllIncompatible);
//        return "cp_employee/cp_employee_change_option";
//    }

    /**
     * This method updates an option with a list of optionsTogether and optionsIncompatible, if any.
     * @param name option's name;
     * @param price option's price;
     * @param initialPrice option's initialPrice;
     * @param optionsTogether an array of option's ids that will be necessary for current option;
     * @param optionsIncompatible an array of option's ids that will be incompatible for current option;
     * @param request request;
     * @param locale locale;
     * @param model model;
     * @return success.jsp
     */
//    @RequestMapping(value = "cp_employee_option_changed", method = RequestMethod.POST)
//    public String finalOptionChange(@RequestParam(value = "name") String name,
//                                    @RequestParam(value = "price") int price,
//                                    @RequestParam(value = "initialPrice") int initialPrice,
//                                    @RequestParam(value = "cb", required = false) int[] optionsTogether,
//                                    @RequestParam(value = "cb2", required = false) int[] optionsIncompatible,
//                                    HttpServletRequest request, Locale locale, Model model) throws Exception{
//        contractValidator.priceCheck(price, "price");
//        contractValidator.priceCheck(initialPrice, "initialPrice");
//        Option option = (Option) request.getSession().getAttribute("option");
//        option.setName(name);
//        option.setPrice(price);
//        option.setInitialPrice(initialPrice);
//        option.removeOptionsIncompatible();
//        option.removeOptionsTogether();
//        //добавить проверку на обход скрипта
//        if (null != optionsTogether && optionsTogether.length > 0) {
//            for (int optionId : optionsTogether) {
//                option.addOptionsTogether(optionService.getEntityById(optionId));
//            }
//        }
//        if (null != optionsIncompatible && optionsIncompatible.length > 0) {
//            for (int optionId : optionsIncompatible) {
//                option.addOptionsIncompatible(optionService.getEntityById(optionId));
//            }
//        }
//        optionService.updateEntity(option);
//        return "cp_employee/success";
//    }

    /**
     * This method deletes an option with the help of entityRemoval.deleteOption method.
     * @param optionId option's id;
     * @param locale locale;
     * @param model model;
     * @return cp_employee_options.jsp
     */
//    @RequestMapping(value = "cp_employee_delete_option", method = RequestMethod.GET)
//    public String deleteOption(@RequestParam(value = "optionId") int optionId,
//                               Locale locale, Model model) {
//        if (optionId == 12) throw new EntityNotDeletedException("This option can not be deleted, as some serious business logic is based upon it!");
//        else {
//            entityRemoval.removeOption(optionId);
//            model.addAttribute("optionsList", optionService.getAll());
//            return "cp_employee/cp_employee_options";
//        }
//    }
//    /*-----------------------------------------------------------------------------------------------*/
//    /*-----------------------------------------------------------------------------------------------*/
//    /*---------------------------------AJAX QUERIES--------------------------------------------------*/
//    /*-----------------------------------------------------------------------------------------------*/
//    /*-----------------------------------------------------------------------------------------------*/
//
//    @RequestMapping(value = "cp_employee_check_number/{number}", method = RequestMethod.GET)
//    @ResponseBody
//    public boolean checkNumber(@PathVariable String number) {
//        long contractNumber = Long.parseLong(Parser.doParse(number));
//        try {
//            contractService.getContractByNumber(contractNumber);
//        }
//        catch (CustomDAOException ex) {
//            return true;
//        }
//        return false;
//    }
//    @RequestMapping(value = "cp_employee_check_user/{login}", method = RequestMethod.GET)
//    @ResponseBody
//    public boolean checkUser(@PathVariable String login) {
//        try {
//            userService.getUserByLogin(login);
//        }
//        catch (CustomDAOException ex) {
//            return false;
//        }
//        return true;
//    }
//    @RequestMapping(value = "cp_employee_tariff_change/{tariffId}", method = RequestMethod.GET)
//    @ResponseBody
//    public List changeTariffData(@PathVariable int tariffId,
//                               HttpServletRequest request, Locale locale, Model model) {
//        TariffOption tariffOption = tariffService.getEntityById(tariffId);
//        List<Option> allOptionsList = optionService.getAll();
//        List<Option> currentTariffOptionsList = optionService.getAllOptionsForTariff(tariffId);
//        allOptionsList.removeAll(currentTariffOptionsList);
//        List<Option> allOptions = new ArrayList<>();
//        List<Option> currentOptions = new ArrayList<>();
//        for (Option option : allOptionsList) {
//            allOptions.add(new Option(option.getId(), option.getName(), option.getPrice(), option.getInitialPrice()));
//
//        }
//        for (Option option : currentTariffOptionsList) {
//            currentOptions.add(new Option(option.getId(), option.getName(), option.getPrice(), option.getInitialPrice()));
//
//        }
//        List list = new ArrayList();
//        Collections.addAll(list, currentOptions, allOptions);
//        return list;
//    }



}
