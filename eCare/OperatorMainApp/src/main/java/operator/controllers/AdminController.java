package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.TariffOption;
import operator.entities.User;
import operator.exceptions.ContractNotFoundException;
import operator.exceptions.UserNotFoundException;
import operator.services.api.ContractService;
import operator.services.api.TariffOptionService;
import operator.services.api.TariffService;
import operator.services.api.UserService;
import operator.utils.SearchResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.UnknownHostException;
import java.util.List;

/**
 * A controllers for dispatching the queries of admins.
 */
@Controller("AdminController")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private TariffService tariffService;
    @Autowired
    private TariffOptionService optionService;
    @Autowired
    private ManagerCases managerCases;
    @Autowired
    private SearchResult searchResult;

    private static final Logger logger = Logger.getLogger(AdminController.class);

    /**
     * Method for dispatching requests to adminNewClient
     *
     * @param req    request to pageuest
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminNewClient
     */
    @RequestMapping(value = "/adminNewClient", method = RequestMethod.GET)
    public String adminNewClientGet(HttpServletRequest request, Model model) {
        return "admin/adminNewClient";
    }

    /**
     * Method for dispatching requests to adminNewClient
     *
     * @param req          request to page
     * @param locale       locale for page
     * @param model        model for page view
     * @param name         client's name
     * @param secondName   client's second name
     * @param birthdayDate client's bithday date
     * @param passport     client's passport
     * @param adress       client's adress
     * @param eMail        client's email
     * @param number       client's number
     * @return page for adminNewClient
     */
    @RequestMapping(value = "/adminNewClient", method = RequestMethod.DELETE)
    @Scope("session")
    public String adminNewClientPost(HttpServletRequest req, Model model,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "surName") String secondName,
                                     @RequestParam(value = "birthday") String birthdayDate,
                                     @RequestParam(value = "passport") String passport,
                                     @RequestParam(value = "adress") String adress,
                                     @RequestParam(value = "email") String eMail,
                                     @RequestParam(value = "number") String number) {
        boolean add = true;
        if (("").equals(name)) {
            req.getSession().setAttribute("nameStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("nameStat", "OK");

        if (("").equals(secondName)) {
            req.getSession().setAttribute("surNameStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("surNameStat", "OK");

        if (("").equals(birthdayDate)) {
            req.getSession().setAttribute("birthday", "Error");
            add = false;
        } else
            req.getSession().setAttribute("birthday", "OK");

        if (("").equals(passport)) {
            req.getSession().setAttribute("passport", "Error");
            add = false;
        } else
            req.getSession().setAttribute("passport", "OK");

        if (("").equals(adress)) {
            req.getSession().setAttribute("adress", "Error");
            add = false;
        } else
            req.getSession().setAttribute("adress", "OK");


        if (managerCases.isUserExists(eMail) || ("").equals(eMail)) {
            req.getSession().setAttribute("email", "Error");
            add = false;
        } else {
            req.getSession().setAttribute("email", "OK");
        }


        if (add == true) {
            managerCases.addUserToBase(name, secondName,
                    birthdayDate, passport, adress, eMail, managerCases.passwordGenerator(5, number, eMail, name));

            req.getSession().setAttribute("newClient", true);
        }

        return "admin/adminNewClient";
    }

    /**
     * Method for dispatching requests to adminNewContract
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminNewContract
     */
    @RequestMapping(value = "/adminNewContract", method = RequestMethod.GET)
    public String adminNewContractGet(HttpServletRequest request, Model model) {
        return "admin/adminNewContract";
    }

    // TODO: 10/2/16 Не фурычит как надо. Дабл ввод

    /**
     * Method for dispatching requests to adminNewContract
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @param eMail  client's email
     * @param number client's number
     * @return page for adminNewContract
     */
    @RequestMapping(value = "/adminNewContract", method = RequestMethod.POST)
    @Scope("session")
    public String adminNewContractPost(HttpServletRequest req, Model model,
                                       @RequestParam(value = "email") String eMail,
                                       @RequestParam(value = "number") String number) {
        boolean add = true;
        if (!managerCases.isUserExists(eMail) || ("").equals(eMail)) {
            req.getSession().setAttribute("emailStat", "Error");
            add = false;
            req.getSession().setAttribute("newContract", false);
        } else {
            req.getSession().setAttribute("emailStat", "OK");
        }

        if (managerCases.isNumberExists(number) || ("").equals(number)) {
            req.getSession().setAttribute("numberStat", "Error");
            add = false;
            req.getSession().setAttribute("newContract", false);
        } else {
            req.getSession().setAttribute("numberStat", "OK");
        }
        if (add == true) {
            req.getSession().setAttribute("newContract", true);
            req.getSession().setAttribute("numberStat", "OK");
            req.getSession().setAttribute("emailStat", "OK");
            managerCases.addContractToBase(eMail, number);
        }

        return "admin/adminNewContract";
    }

    /**
     * Method for dispatching requests to adminChangeClientTariff
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminChangeClientTariff
     */
    @RequestMapping(value = "/adminChangeClientTariff", method = RequestMethod.GET)
    @Scope("session")
    public String adminChangeClientTariffGet(HttpServletRequest req, Model model) {
        req.getSession().setAttribute("allTariffs", tariffService.getAll());
        return "admin/adminChangeClientTariff";
    }

    /**
     * Method for dispatching requests to adminChangeClientTariff
     *
     * @param req            request from pag
     * @param locale         locale for page
     * @param model          model for page view
     * @param tariffId       contract's id
     * @param contractNumber contract's number
     * @return page for adminChangeClientTariff
     */
    @RequestMapping(value = "/adminChangeClientTariff", method = RequestMethod.POST)
    public String changeTariff(HttpServletRequest request, Model model,
                               @RequestParam(value = "tariffId") String tariffId,
                               @RequestParam(value = "contractNumber") String contractNumber) {
        int tariffID = Integer.parseInt(tariffId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        Tariff tariff = tariffService.getEntityById(tariffID);
        contract.setTariff(tariff);
        contractService.updateEntity(contract);
        return "redirect:adminChangeClientTariff";
    }

    /**
     * Method for dispatching requests to adminChangeClient
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminChangeClient
     */
    @RequestMapping(value = "/adminChangeClient", method = RequestMethod.GET)
    @Scope("session")
    public String adminChangeClientGet(HttpServletRequest req, Model model) {
        req.getSession().setAttribute("tariffOptions", optionService.getAll());
        return "admin/adminChangeClient";
    }

    /**
     * Method for dispatching requests to adminChangeClient
     *
     * @param req            request to page
     * @param resp           response from page
     * @param locale         locale for page
     * @param model          model for page view
     * @param contractNumber contract's number
     * @param tariffOptionId contract's id
     * @param method         method of changing
     * @return page for adminChangeClient
     */
    @RequestMapping(value = "/adminChangeClient", method = RequestMethod.POST)
    public String chgangeTariffOptions(HttpServletRequest request, HttpServletResponse resp, Model model,
                                       @RequestParam(value = "contractNumber") String contractNumber,
                                       @RequestParam(value = "tariffOptionId") String tariffOptionId,
                                       @RequestParam(value = "method") String method) {
        int tariffOptionID = Integer.parseInt(tariffOptionId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        TariffOption tariffOption = optionService.getEntityById(tariffOptionID);
        if (("unable").equals(method)) {
            List<TariffOption> jointOptions;
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
                resp.setStatus(405);
            }
        } else {
            contract.getTariffOptions().remove(tariffOption);
            contractService.updateEntity(contract);
        }
        return "admin/adminChangeClient";
    }

    /**
     * Method for dispatching requests to adminContractControl
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminContractControl
     */
    @RequestMapping(value = "/adminContractControl", method = RequestMethod.GET)
    @Scope("session")
    public String adminContractControl(HttpServletRequest req, Model model) {
        User user = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("userObj", user);
        req.getSession().setAttribute("userName", user.getName());
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        model.addAttribute("contracts", contracts);
        return "admin/adminContractControl";
    }

    /**
     * Method for dispatching requests to adminContractControl
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @param status status for operations
     * @param number number for operations
     * @return page for adminContractControl
     */
    @RequestMapping(value = "/adminContractControl", method = RequestMethod.POST)
    public String adminContractControlDelete(HttpServletRequest req, Model model,
                                             @RequestParam(value = "status") String status,
                                             @RequestParam(value = "number") String number) {
        if (("block").equals(status)) {
            Contract contract = contractService.getContractByNumber(number);
            contract.setBlocked(true);
            contract.setBlockedByAdmin(true);
            contractService.updateEntity(contract);
        } else {
            Contract contract = contractService.getContractByNumber(number);
            contract.setBlocked(false);
            contract.setBlockedByAdmin(false);
            contractService.updateEntity(contract);
        }
        return "admin/adminContractControl";
    }

    /**
     * Method for dispatching requests to adminNewTariff
     *
     * @param req   request to page
     * @param model model for page view
     * @return page for adminNewTariff
     */
    @RequestMapping(value = "/adminNewTariff", method = RequestMethod.GET)
    public String adminNewTariffGet(HttpServletRequest request, Model model) {
        return "admin/adminNewTariff";
    }

    // TODO: 9/30/16 Фигня какая-то. Проверь!!!!

    /**
     * Method for dispatching requests to adminNewTariff
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @param title  tariff title
     * @param price  tariff prive
     * @return page for adminNewTariff
     */
    @RequestMapping(value = "/adminNewTariff", method = RequestMethod.POST)
    @Scope("session")
    public String adminNewTariffPost(HttpServletRequest req, Model model,
                                     @RequestParam(value = "title") String title,
                                     @RequestParam(value = "price") String price) {
        boolean add = true;

        if (("").equals(title) || managerCases.isTariffExists(title)) {
            req.getSession().setAttribute("titleStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("titleStat", "OK");

        if (("").equals(price)) {
            req.getSession().setAttribute("priceStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("priceStat", "OK");

        if (add == true) {
            req.getSession().setAttribute("newTariff", true);
            managerCases.addTariffToBase(title, price);
        }
        return "admin/adminNewTariff";
    }

    /**
     * Method for dispatching requests to adminEditTariff
     *
     * @param req    request to pageuest
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminEditTariff
     */
    @RequestMapping(value = "/adminEditTariff", method = RequestMethod.GET)
    public String adminEditTariffGet(HttpServletRequest request, Model model) {
        model.addAttribute("tariffs", tariffService.getAll());
        return "admin/adminEditTariff";
    }

    /**
     * Method for dispatching requests to adminEditTariff
     *
     * @param req      request to pageuest
     * @param locale   locale for page
     * @param model    model for page view
     * @param tariffId
     * @return page for adminEditTariff
     */
    @RequestMapping(value = "/adminEditTariff", method = RequestMethod.POST)
    public String adminEditTariffPost(HttpServletRequest request, Model model,
                                      @RequestParam(value = "tariffId") String tariffId) {
        int tariffID = Integer.parseInt(tariffId);
        Tariff tariff = tariffService.getEntityById(tariffID);
        managerCases.removeTariff(tariff);
        return "admin/adminEditTariff";
    }

    /**
     * Method for dispatching requests to adminNewOption
     *
     * @param req    request to pageuest
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminNewOption
     */
    @RequestMapping(value = "/adminNewOption", method = RequestMethod.GET)
    public String adminNewOptionGet(HttpServletRequest request, Model model) {
        return "admin/adminNewOption";
    }

    /**
     * Method for dispatching requests to adminNewOption
     *
     * @param req          request to page
     * @param locale       locale for page
     * @param model        model for page view
     * @param title        option title
     * @param price        option price
     * @param connectPrice option connect price
     * @return page for adminNewOption
     */
    @RequestMapping(value = "/adminNewOption", method = RequestMethod.POST)
    @Scope("session")
    public String adminNewOptionPost(HttpServletRequest req, Model model,
                                     @RequestParam(value = "title") String title,
                                     @RequestParam(value = "price") String price,
                                     @RequestParam(value = "connectPrice") String connectPrice) {
        boolean add = true;
        String connectionPrice = req.getParameter("connectPrice");
        if (("").equals(title) || managerCases.isOptionExists(title)) {
            req.getSession().setAttribute("titleStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("titleStat", "OK");

        if (("").equals(price)) {
            req.getSession().setAttribute("priceStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("priceStat", "OK");

        if (("").equals(connectionPrice)) {
            req.getSession().setAttribute("connectionPriceStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("connectionPriceStat", "OK");

        if (add == true) {
            req.getSession().setAttribute("newOption", true);
            managerCases.addOptionToBase(title, price, connectionPrice);
        }
        return "admin/adminNewOption";
    }

    /**
     * Method for dispatching requests to adminEditTariffOption
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminEditTariffOption
     */
    @RequestMapping(value = "/adminEditTariffOption", method = RequestMethod.GET)
    public String adminEditTariffOptionGet(HttpServletRequest request, Model model) {
        model.addAttribute("options", optionService.getAll());
        return "admin/adminEditTariffOption";
    }

    /**
     * Method for dispatching requests to adminEditTariffOption
     *
     * @param req            request to page
     * @param locale         locale for page
     * @param model          model for page view
     * @param tariffOptionId option id
     * @return page for adminEditTariffOption
     */
    @RequestMapping(value = "/adminEditTariffOption", method = RequestMethod.POST)
    public String adminEditTariffOptionPost(HttpServletRequest request, Model model,
                                            @RequestParam(value = "tariffOptionId") String tariffOptionId) {
        int tariffOptionID = Integer.parseInt(tariffOptionId);
        TariffOption tariffOption = optionService.getEntityById(tariffOptionID);
        managerCases.removeTariffOption(tariffOption);
        return "admin/adminEditTariffOption";
    }

    /**
     * Method for dispatching requests to adminConnectOption
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminConnectOption
     */
    @RequestMapping(value = "/adminConnectOption", method = RequestMethod.GET)
    public String adminConnectOptionGet(HttpServletRequest request, Model model) {
        model.addAttribute("options", optionService.getAllJoinedTariffOption(0));
        return "admin/adminJointOption";
    }

    /**
     * Method for dispatching requests to adminConnectOption
     *
     * @param req       request to page
     * @param locale    locale for page
     * @param model     model for page view
     * @param tariffOne first tariff
     * @param tariffTwo second tariff
     * @return page for adminConnectOption
     */
    @RequestMapping(value = "/adminConnectOption", method = RequestMethod.POST)
    @Scope("session")
    public String adminConnectOptionPost(HttpServletRequest req, Model model,
                                         @RequestParam(value = "tariffOne") String tariffOne,
                                         @RequestParam(value = "tariffTwo") String tariffTwo) {
        boolean add = true;

        if (("").equals(tariffOne) || !managerCases.isOptionExists(tariffOne)) {
            req.getSession().setAttribute("oneStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("oneStat", "OK");

        if (("").equals(tariffTwo) || !managerCases.isOptionExists(tariffTwo)) {
            req.getSession().setAttribute("twoStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("twoStat", "OK");

        if (add == true) {
            req.getSession().setAttribute("newConnect", true);
            managerCases.addJoinOptionToBase(tariffOne, tariffTwo);
        }

        return "admin/adminJointOption";
    }

    /**
     * Method for dispatching requests to adminImpossibleOption
     *
     * @param req    request to pageuest
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminImpossibleOption
     */
    @RequestMapping(value = "/adminImpossibleOption", method = RequestMethod.GET)
    public String adminImpossibleOptionGet(HttpServletRequest request, Model model) {
        return "admin/adminImpossibleOptions";
    }

    /**
     * Method for dispatching requests to adminImpossibleOption
     *
     * @param req       request to page
     * @param locale    locale for page
     * @param model     model for page view
     * @param tariffOne first tariff
     * @param tariffTwo second tariff
     * @return page for adminImpossibleOption
     */
    @RequestMapping(value = "/adminImpossibleOption", method = RequestMethod.POST)
    @Scope("session")
    public String adminImpossibleOptionPost(HttpServletRequest req, Model model,
                                            @RequestParam(value = "tariffOne") String tariffOne,
                                            @RequestParam(value = "tariffTwo") String tariffTwo) {
        boolean add = true;

        if (("").equals(tariffOne) || !managerCases.isOptionExists(tariffOne)) {
            req.getSession().setAttribute("oneStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("oneStat", "OK");

        if (("").equals(tariffTwo) || !managerCases.isOptionExists(tariffTwo)) {
            req.getSession().setAttribute("twoStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("twoStat", "OK");

        if (add == true) {
            req.getSession().setAttribute("ImConnect", true);
            managerCases.addImmposibleOptionToBase(tariffOne, tariffTwo);
        }
        return "admin/adminImpossibleOptions";
    }

    /**
     * Method for dispatching requests to adminDeleteImOptions
     *
     * @param req    request to pageuest
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminDeleteImOptions
     */
    @RequestMapping(value = "/adminDeleteImOptions", method = RequestMethod.GET)
    public String adminDeleteImOptionsGet(HttpServletRequest request, Model model) {
        model.addAttribute("options", optionService.getAll());
        return "admin/adminDeleteImOptions";
    }

    /**
     * Method for dispatching requests to adminDeleteImOptions
     *
     * @param req            request to pageuest
     * @param locale         locale for page
     * @param model          model for page view
     * @param tariffOptionId option id
     * @return page for adminDeleteImOptions
     */
    // TODO: 10/7/16 Чтобы убиралась лишняя херня сделать 
    @RequestMapping(value = "/adminDeleteImOptions", method = RequestMethod.POST)
    public String adminDeleteImOptionsPost(HttpServletRequest request, Model model,
                                           @RequestParam(value = "modified") String modified,
                                           @RequestParam(value = "removed") String removed) {
        int modifiedOptId = Integer.parseInt(modified);
        int removedOptId = Integer.parseInt(removed);
        TariffOption modifiedOpt = optionService.getEntityById(modifiedOptId);
        TariffOption removedOpt = optionService.getEntityById(removedOptId);
        managerCases.deleteImpossibleOption(modifiedOpt, removedOpt);
        return "admin/adminDeleteImOptions";
    }

    /**
     * Method for dispatching requests to adminDeleteJoOptions
     *
     * @param req    request to pageuest
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminDeleteJoOptions
     */
    @RequestMapping(value = "/adminDeleteJoOptions", method = RequestMethod.GET)
    public String adminDeleteJoOptionsGet(HttpServletRequest request, Model model) {
        model.addAttribute("options", optionService.getAll());
        return "admin/adminDeleteJoOptions";
    }

    /**
     * Method for dispatching requests to adminDeleteJoOptions
     *
     * @param req            request to pageuest
     * @param locale         locale for page
     * @param model          model for page view
     * @param tariffOptionId option id
     * @return page for adminDeleteJoOptions
     */
    @RequestMapping(value = "/adminDeleteJoOptions", method = RequestMethod.POST)
    public String adminDeleteJoOptionsPost(HttpServletRequest request, Model model,
                                           @RequestParam(value = "modified") String modified,
                                           @RequestParam(value = "removed") String removed) {
        int modifiedOptId = Integer.parseInt(modified);
        int removedOptId = Integer.parseInt(removed);
        TariffOption modifiedOpt = optionService.getEntityById(modifiedOptId);
        TariffOption removedOpt = optionService.getEntityById(removedOptId);
        managerCases.deleteJoinOption(modifiedOpt, removedOpt);
        return "admin/adminDeleteJoOptions";
    }

    /**
     * Method for dispatching requests to adminViewClient
     *
     * @param req    request to pageuest
     * @param locale locale for page
     * @param model  model for page view
     * @return page for
     */
    @RequestMapping(value = "/adminViewClient", method = RequestMethod.GET)
    public String adminViewClientGet(HttpServletRequest request, Model model) {
        return "admin/adminViewClient";
    }

    /**
     * Method for dispatching requests to adminViewClient
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @param email  client's email
     * @return page for adminViewClient
     */
    @RequestMapping(value = "/adminViewClient", method = RequestMethod.POST)
    @Scope("session")
    public String adminViewClientPost(HttpServletRequest req, Model model,
                                      @RequestParam(value = "email") String email) {
        req.getSession().setAttribute("chck", "work");
        try {
            User user = userService.getUserByEMAil(email);
            req.getSession().setAttribute("usrs", user);
        } catch (UserNotFoundException ex) {
            req.getSession().setAttribute("usrs", "one");
            logger.info(ex);
        }
        return "admin/adminViewClient";
    }

    /**
     * Method for dispatching requests to adminFindClient
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @return page for adminFindClient
     */
    @RequestMapping(value = "/adminFindClient", method = RequestMethod.GET)
    public String adminFindClientGet(HttpServletRequest req, Model model) {
        return "admin/adminFindClient";
    }

    /**
     * Method for dispatching requests to adminFindClient
     *
     * @param req    request to page
     * @param locale locale for page
     * @param model  model for page view
     * @param number client's number
     * @return page for adminFindClient
     */
    @RequestMapping(value = "/adminFindClient", method = RequestMethod.POST)
    @Scope("session")
    public String adminFindClientPost(HttpServletRequest req, Model model,
                                      @RequestParam(value = "number") String number) {
        req.getSession().setAttribute("check", "work");
        try {
            Contract contract = contractService.getContractByNumber(number);
            req.getSession().setAttribute("usr", contract);

        } catch (ContractNotFoundException ex) {
            req.getSession().setAttribute("usr", "one");
            logger.info(ex);
        }
        return "admin/adminFindClient";
    }

    /**
     * Method for dispatching requests to adminFindClient adminRest
     *
     * @param request request to page
     * @param model   model for page view
     * @return page for adminRest
     */
    @RequestMapping(value = "/adminRest", method = RequestMethod.GET)
    public String adminRest(HttpServletRequest request, Model model) {
        return "admin/adminRest";
    }

    /**
     * Method for dispatching requests to userSearch page
     *
     * @param req   request from page
     * @param model model for page view
     * @param query query for searching
     * @return page for userSearch
     */
    @RequestMapping(value = "/adminSearch", method = RequestMethod.POST)
    public String searchingPost(HttpServletRequest req, Model model,
                                @RequestParam(value = "query") String query) throws UnknownHostException {
        String result = searchResult.getResults(query);
        model.addAttribute("searchResult", result);
        return "admin/adminSearch";
    }
}
