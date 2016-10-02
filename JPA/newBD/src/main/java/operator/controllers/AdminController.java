package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.TariffOption;
import operator.entities.User;
import operator.exceptions.ContractNotFoundException;
import operator.exceptions.UserNotFoundException;
import operator.integration.ContractValidator;
import operator.integration.EntityRemoval;
import operator.integration.UserUpdater;
import operator.services.api.ContractService;
import operator.services.api.TariffOptionService;
import operator.services.api.TariffService;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
 * A controllers to dispatch the queries of admins.
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
    private ContractValidator contractValidator;
    @Autowired
    private UserUpdater userUpdater;
    @Autowired
    private EntityRemoval entityRemoval;
    @Autowired
    private ManagerCases managerCases;

    @RequestMapping(value = "/adminNewClient", method = RequestMethod.GET)
    public String adminNewClientGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminNewClient";
    }

    @RequestMapping(value = "/adminNewClient", method = RequestMethod.DELETE)
    @Scope("session")
    public String adminNewClientPost(HttpServletRequest req, Locale locale, Model model,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "surName") String secondName,
                                     @RequestParam(value = "birthday") String birthdayDate,
                                     @RequestParam(value = "passport") String passport,
                                     @RequestParam(value = "adress") String adress,
                                     @RequestParam(value = "email") String eMail,
                                     @RequestParam(value = "number") String number) {
        boolean add = true;
        if (name.equals("")) {
            req.getSession().setAttribute("nameStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("nameStat", "OK");

        if (secondName.equals("")) {
            req.getSession().setAttribute("surNameStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("surNameStat", "OK");

        if (birthdayDate.equals("")) {
            req.getSession().setAttribute("birthday", "Error");
            add = false;
        } else
            req.getSession().setAttribute("birthday", "OK");

        if (passport.equals("")) {
            req.getSession().setAttribute("passport", "Error");
            add = false;
        } else
            req.getSession().setAttribute("passport", "OK");

        if (adress.equals("")) {
            req.getSession().setAttribute("adress", "Error");
            add = false;
        } else
            req.getSession().setAttribute("adress", "OK");


        if (managerCases.isUserExists(eMail) || eMail.equals("")) {
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

    @RequestMapping(value = "/adminNewContract", method = RequestMethod.GET)
    public String adminNewContractGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminNewContract";
    }

    // TODO: 10/2/16 Не фурычит как надо. Дабл ввод
    @RequestMapping(value = "/adminNewContract", method = RequestMethod.POST)
    @Scope("session")
    public String adminNewContractPost(HttpServletRequest req, Locale locale, Model model,
                                       @RequestParam(value = "email") String eMail,
                                       @RequestParam(value = "number") String number) {
        boolean add = true;
        if (!managerCases.isUserExists(eMail) || eMail.equals("")) {
            req.getSession().setAttribute("emailStat", "Error");
            add = false;
            req.getSession().setAttribute("newContract", false);
        } else {
            req.getSession().setAttribute("emailStat", "OK");
        }

        if (managerCases.isNumberExists(number) || number.equals("")) {
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

    @RequestMapping(value = "/adminChangeClientTariff", method = RequestMethod.GET)
    @Scope("session")
    public String adminChangeClientTariffGet(HttpServletRequest req, Locale locale, Model model) {
        req.getSession().setAttribute("allTariffs", tariffService.getAll());
        return "admin/adminChangeClientTariff";
    }

    @RequestMapping(value = "/adminChangeClientTariff", method = RequestMethod.POST)
    public String changeTariff(HttpServletRequest request, Locale locale, Model model,
                               @RequestParam(value = "tariffId") String tariffId,
                               @RequestParam(value = "contractNumber") String contractNumber) {
        int tariffID = Integer.valueOf(tariffId);
        Contract contract = contractService.getContractByNumber(contractNumber);
        Tariff tariff = tariffService.getEntityById(tariffID);
        contract.setTariff(tariff);
        contractService.updateEntity(contract);
        return "redirect:adminChangeClientTariff";
    }

    @RequestMapping(value = "/adminChangeClient", method = RequestMethod.GET)
    @Scope("session")
    public String adminChangeClientGet(HttpServletRequest req, Locale locale, Model model) {
        User user = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("tariffOptions", optionService.getAll());

        return "admin/adminChangeClient";
    }

    @RequestMapping(value = "/adminChangeClient", method = RequestMethod.POST)
    public String chgangeTariffOptions(HttpServletRequest request, HttpServletResponse resp, Locale locale, Model model,
                                       @RequestParam(value = "contractNumber") String contractNumber,
                                       @RequestParam(value = "tariffOptionId") String tariffOptionId,
                                       @RequestParam(value = "method") String method) {
        System.out.println(contractNumber + " " + tariffOptionId + " " + method);
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
                resp.setStatus(405);
            }
        } else {
            contract.getTariffOptions().remove(tariffOption);
            contractService.updateEntity(contract);
        }
        return "admin/adminChangeClient";
    }

    @RequestMapping(value = "/adminContractControl", method = RequestMethod.GET)
    @Scope("session")
    public String adminContractControl(HttpServletRequest req, Locale locale, Model model) {
        User user = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("userObj", user);
        req.getSession().setAttribute("userName", user.getName());
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        model.addAttribute("contracts", contracts);
        return "admin/adminContractControl";
    }

    @RequestMapping(value = "/adminContractControl", method = RequestMethod.POST)
    public String adminContractControlDelete(HttpServletRequest req, Locale locale, Model model,
                                             @RequestParam(value = "status") String status,
                                             @RequestParam(value = "number") String number) {
        if (status.equals("block")) {
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


    @RequestMapping(value = "/adminNewTariff", method = RequestMethod.GET)
    public String adminNewTariffGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminNewTariff";
    }

    // TODO: 9/30/16 Фигня какая-то. Проверь!!!!
    @RequestMapping(value = "/adminNewTariff", method = RequestMethod.POST)
    @Scope("session")
    public String adminNewTariffPost(HttpServletRequest req, Locale locale, Model model,
                                     @RequestParam(value = "title") String title,
                                     @RequestParam(value = "price") String price) {
        boolean add = true;

        if (title.equals("") || managerCases.isTariffExists(title)) {
            req.getSession().setAttribute("titleStat", "Error");
            add = false;
        } else
            req.getSession().setAttribute("titleStat", "OK");

        if (price.equals("")) {
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

    @RequestMapping(value = "/adminEditTariff", method = RequestMethod.GET)
    public String adminEditTariffGet(HttpServletRequest request, Locale locale, Model model) {
        model.addAttribute("tariffs", tariffService.getAll());
        return "admin/adminEditTariff";
    }

    @RequestMapping(value = "/adminEditTariff", method = RequestMethod.POST)
    public String adminEditTariffPost(HttpServletRequest request, Locale locale, Model model,
                                      @RequestParam(value = "tariffId") String tariffId) {
        int tariffID = Integer.parseInt(tariffId);
        Tariff tariff = tariffService.getEntityById(tariffID);
        tariffService.deleteEntity(tariff);
        return "admin/adminEditTariff";
    }

    @RequestMapping(value = "/adminNewOption", method = RequestMethod.GET)
    public String adminNewOptionGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminNewOption";
    }

    @RequestMapping(value = "/adminNewOption", method = RequestMethod.POST)
    public String adminNewOptionPost(HttpServletRequest req, Locale locale, Model model,
                                     @RequestParam(value = "title") String title,
                                     @RequestParam(value = "price") String price) {
        boolean add = true;
        String connectionPrice = req.getParameter("connectPrice");
        if (title.equals("") || managerCases.isOptionExists(title)) {
            model.addAttribute("titleStat", "Error");
            add = false;
        } else
            model.addAttribute("titleStat", "OK");

        if (price.equals("")) {
            model.addAttribute("priceStat", "Error");
            add = false;
        } else
            model.addAttribute("priceStat", "OK");

        if (connectionPrice.equals("")) {
            model.addAttribute("connectionPriceStat", "Error");
            add = false;
        } else
            model.addAttribute("connectionPriceStat", "OK");

        if (add == true) managerCases.addOptionToBase(title, price, connectionPrice);
        return "admin/adminNewOption";
    }

    @RequestMapping(value = "/adminEditTariffOption", method = RequestMethod.GET)
    public String adminEditTariffOptionGet(HttpServletRequest request, Locale locale, Model model) {
        model.addAttribute("options", optionService.getAll());
        return "admin/adminEditTariffOption";
    }

    @RequestMapping(value = "/adminEditTariffOption", method = RequestMethod.POST)
    public String adminEditTariffOptionPost(HttpServletRequest request, Locale locale, Model model,
                                            @RequestParam(value = "tariffOptionId") String tariffOptionId) {
        int tariffOptionID = Integer.parseInt(tariffOptionId);
        TariffOption tariffOption = optionService.getEntityById(tariffOptionID);
        optionService.deleteEntity(tariffOption);
        return "admin/adminEditTariffOption";
    }

    @RequestMapping(value = "/adminConnectOption", method = RequestMethod.GET)
    public String adminConnectOptionGet(HttpServletRequest request, Locale locale, Model model) {
        model.addAttribute("options", optionService.getAllJoinedTariffOption(0));
        return "admin/adminEditTariffOption";
    }

    @RequestMapping(value = "/adminConnectOption", method = RequestMethod.POST)
    public String adminConnectOptionPost(HttpServletRequest request, Locale locale, Model model,
                                         @RequestParam(value = "tariffOne") String tariffOne,
                                         @RequestParam(value = "tariffTwo") String tariffTwo) {
        boolean add = true;
        System.out.println(tariffOne + " " + tariffTwo);

        if (tariffOne.equals("") || !managerCases.isOptionExists(tariffOne)) {
            model.addAttribute("oneStat", "Error");
            add = false;
        } else
            model.addAttribute("oneStat", "OK");

        if (tariffTwo.equals("") || !managerCases.isOptionExists(tariffTwo)) {
            model.addAttribute("twoStat", "Error");
            add = false;
        } else
            model.addAttribute("twoStat", "OK");

        if (add == true) {
            System.out.println("here");
            managerCases.addJoinOptionToBase(tariffOne, tariffTwo);
        }

        return "admin/adminEditTariffOption";
    }

    @RequestMapping(value = "/adminImpossibleOption", method = RequestMethod.GET)
    public String adminImpossibleOptionGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminImpossibleOptions";
    }

    @RequestMapping(value = "/adminImpossibleOption", method = RequestMethod.POST)
    public String adminImpossibleOptionPost(HttpServletRequest request, Locale locale, Model model,
                                            @RequestParam(value = "tariffOne") String tariffOne,
                                            @RequestParam(value = "tariffTwo") String tariffTwo) {
        boolean add = true;
        System.out.println(tariffOne + " " + tariffTwo);

        if (tariffOne.equals("") || !managerCases.isOptionExists(tariffOne)) {
            model.addAttribute("oneStat", "Error");
            add = false;
        } else
            model.addAttribute("oneStat", "OK");

        if (tariffTwo.equals("") || !managerCases.isOptionExists(tariffTwo)) {
            model.addAttribute("twoStat", "Error");
            add = false;
        } else
            model.addAttribute("twoStat", "OK");

        if (add == true) {
            managerCases.addImmposibleOptionToBase(tariffOne, tariffTwo);
        }
        return "admin/adminImpossibleOptions";
    }

    @RequestMapping(value = "/adminDeleteImOptions", method = RequestMethod.GET)
    public String adminDeleteImOptionsGet(HttpServletRequest request, Locale locale, Model model) {
        model.addAttribute("options", optionService.getAllImpossibleTariffOption(0));
        return "admin/adminDeleteImOptions";
    }

    @RequestMapping(value = "/adminDeleteImOptions", method = RequestMethod.POST)
    public String adminDeleteImOptionsPost(HttpServletRequest request, Locale locale, Model model,
                                           @RequestParam(value = "tariffOptionId") String tariffOptionId) {
        int tariffOptionID = Integer.parseInt(tariffOptionId);
        TariffOption tariffOption = optionService.getEntityById(tariffOptionID);
        optionService.deleteEntity(tariffOption);
        return "admin/adminDeleteImOptions";
    }

    @RequestMapping(value = "/adminDeleteJoOptions", method = RequestMethod.GET)
    public String adminDeleteJoOptionsGet(HttpServletRequest request, Locale locale, Model model) {
        model.addAttribute("options", optionService.getAllJoinedTariffOption(0));
        return "admin/adminDeleteJoOptions";
    }

    @RequestMapping(value = "/adminDeleteJoOptions", method = RequestMethod.POST)
    public String adminDeleteJoOptionsPost(HttpServletRequest request, Locale locale, Model model,
                                           @RequestParam(value = "tariffOptionId") String tariffOptionId) {
        int tariffOptionID = Integer.parseInt(tariffOptionId);
        TariffOption tariffOption = optionService.getEntityById(tariffOptionID);
        optionService.deleteEntity(tariffOption);
        return "admin/adminDeleteJoOptions";
    }

    @RequestMapping(value = "/adminViewClient", method = RequestMethod.GET)
    public String adminViewClientGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminViewClient";
    }

    @RequestMapping(value = "/adminViewClient", method = RequestMethod.POST)
    @Scope("session")
    public String adminViewClientPost(HttpServletRequest req, Locale locale, Model model,
                                      @RequestParam(value = "email") String email) {
        req.getSession().setAttribute("chck", "work");
        try {
            User user = userService.getUserByEMAil(email);
            req.getSession().setAttribute("usrs", user);
        } catch (UserNotFoundException ex) {
            req.getSession().setAttribute("usrs", "one");
        }
        return "admin/adminViewClient";
    }

    @RequestMapping(value = "/adminFindClient", method = RequestMethod.GET)
    public String adminFindClientGet(HttpServletRequest req, Locale locale, Model model) {
        return "admin/adminFindClient";
    }

    @RequestMapping(value = "/adminFindClient", method = RequestMethod.POST)
    @Scope("session")
    public String adminFindClientPost(HttpServletRequest req, Locale locale, Model model,
                                      @RequestParam(value = "number") String number) {
        req.getSession().setAttribute("check", "work");
        try {
            Contract contract = contractService.getContractByNumber(number);
            req.getSession().setAttribute("usr", contract);

        } catch (ContractNotFoundException ex) {
            req.getSession().setAttribute("usr", "one");
        }
        return "admin/adminFindClient";
    }
}
