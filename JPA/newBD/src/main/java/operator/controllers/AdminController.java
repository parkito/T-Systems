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
            model.addAttribute("nameStat", "Error");
            add = false;
        } else
            model.addAttribute("nameStat", "OK");

        if (secondName.equals("")) {
            model.addAttribute("surNameStat", "Error");
            add = false;
        } else
            model.addAttribute("surNameStat", "OK");

        if (birthdayDate.equals("")) {
            model.addAttribute("birthday", "Error");
            add = false;
        } else
            model.addAttribute("birthday", "OK");

        if (passport.equals("")) {
            model.addAttribute("passport", "Error");
            add = false;
        } else
            model.addAttribute("passport", "OK");

        if (adress.equals("")) {
            model.addAttribute("adress", "Error");
            add = false;
        } else
            model.addAttribute("adress", "OK");


        if (managerCases.isUserExists(eMail) || eMail.equals("")) {
            model.addAttribute("email", "Error");
            add = false;
        } else {
            model.addAttribute("email", "OK");
        }


        if (add == true) {
            managerCases.addUserToBase(name, secondName,
                    birthdayDate, passport, adress, eMail, managerCases.passwordGenerator(5, number, eMail, name));

            model.addAttribute("newClient", true);
        }

        return "admin/adminNewClient";
    }

    @RequestMapping(value = "/adminNewContract", method = RequestMethod.GET)
    public String adminNewContractGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminNewContract";
    }

    // TODO: 9/29/16 Хрен знает почему не фурычит
    @RequestMapping(value = "/adminNewContract", method = RequestMethod.POST)
    public String adminNewContractPost(HttpServletRequest req, Locale locale, Model model,
                                       @RequestParam(value = "email") String eMail,
                                       @RequestParam(value = "number") String number) {
        System.out.println(eMail + " " + number);
        boolean add = true;
        if (!managerCases.isUserExists(eMail) || eMail.equals("")) {
            model.addAttribute("emailStat", "Error");
            add = false;
        } else {
            model.addAttribute("emailStat", "OK");
        }

        if (managerCases.isNumberExists(number) || number.equals("")) {
            model.addAttribute("numberStat", "Error");
            add = false;
        } else {
            model.addAttribute("numberStat", "OK");
        }
        if (add == true) {
            model.addAttribute("newContract", true);
            addContractToBase(eMail, number);
        }

        return "admin/adminNewContract";
    }

    @RequestMapping(value = "/adminChangeClientTariff", method = RequestMethod.GET)
    public String adminChangeClientTariff(HttpServletRequest req, Locale locale, Model model) {
        int count = 1;
        if (count == 1) {
            model.addAttribute("check", "start");
            count++;
        }
        User user = (User) req.getSession().getAttribute("currentUser");
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        List<Tariff> tariffs = tariffService.getAll();

        model.addAttribute("contracts", contracts);
        model.addAttribute("allTariffs", tariffs);
        return "admin/adminChangeClientTariff";
    }

    @RequestMapping(value = "/adminChangeClient", method = RequestMethod.GET)
    public String adminChangeClient(HttpServletRequest req, Locale locale, Model model) {
        int count = 1;
        if (count == 1) {
            model.addAttribute("check", "start");
            count++;
        }
        User user = (User) req.getSession().getAttribute("currentUser");
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());

        model.addAttribute("contracts", contracts);
        model.addAttribute("tariffOptions", optionService.getAll());

        return "admin/adminChangeClient";
    }

    @RequestMapping(value = "/adminContractControl", method = RequestMethod.GET)
    public String adminContractControl(HttpServletRequest req, Locale locale, Model model) {
        int count = 1;
        if (count == 1) {
            model.addAttribute("check", "start");
            count++;
        }
        User user = (User) req.getSession().getAttribute("currentUser");
        model.addAttribute("userObj", user);
        String userName = user.getName();
        model.addAttribute("userName", userName);
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        model.addAttribute("contracts", contracts);
        return "admin/adminContractControl";
    }

    @RequestMapping(value = "/adminContractControl", method = RequestMethod.DELETE)
    public String adminContractControlDelete(HttpServletRequest req, Locale locale, Model model,
                                             @RequestParam(value = "unblockItem") String unblockItem,
                                             @RequestParam(value = "blockItem") String blockItem) {
        if (blockItem != null) {
            Contract contract = contractService.getContractByNumber(req.getParameter("blockItem"));
            contract.setBlocked(true);
            contract.setBlockedByAdmin(true);
            contractService.updateEntity(contract);
        }

        if (unblockItem != null) {
            Contract contract = contractService.getContractByNumber(req.getParameter("unblockItem"));
            contract.setBlocked(false);
            contract.setBlockedByAdmin(false);
            contractService.updateEntity(contract);


        }
        return "admin/adminContractControl";
    }

    public void addContractToBase(String eMail, String number) {
        Contract contract = new Contract(number, userService.getUserByEMAil(eMail),
                tariffService.getTariffByTitle("base"));
        contractService.createEntity(contract);
    }

    @RequestMapping(value = "/adminNewTariff", method = RequestMethod.GET)
    public String adminNewTariffGet(HttpServletRequest request, Locale locale, Model model) {
        return "admin/adminNewTariff";
    }

    // TODO: 9/30/16 Фигня какая-то. Проверь!!!! 
    @RequestMapping(value = "/adminNewTariff", method = RequestMethod.POST)
    public String adminNewTariffPost(HttpServletRequest req, Locale locale, Model model,
                                     @RequestParam(value = "title") String title,
                                     @RequestParam(value = "price") String price) {
        boolean add = true;

        if (title.equals("") || managerCases.isTariffExists(title)) {
            model.addAttribute("titleStat", "Error");
            add = false;
        } else
            model.addAttribute("titleStat", "OK");

        if (price.equals("")) {
            model.addAttribute("priceStat", "Error");
            add = false;
        } else
            model.addAttribute("priceStat", "OK");

        if (add == true) managerCases.addTariffToBase(title, price);
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
        model.addAttribute("check", "work");
        return "admin/adminViewClient";
    }

    @RequestMapping(value = "/adminViewClient", method = RequestMethod.POST)
    public String adminViewClientPost(HttpServletRequest request, Locale locale, Model model,
                                      @RequestParam(value = "email") String email) {
        System.out.println(email);
        model.addAttribute("check", "work");
        try {
            User user = userService.getUserByEMAil(email);
            model.addAttribute("usrs", user);

        } catch (UserNotFoundException ex) {
            model.addAttribute("usrs", null);
        }
        return "admin/adminViewClient";
    }

    @RequestMapping(value = "/adminFindClient", method = RequestMethod.GET)
    public String adminFindClientGet(HttpServletRequest request, Locale locale, Model model) {
        model.addAttribute("check", "work");
        return "admin/adminFindClient";
    }

    @RequestMapping(value = "/adminFindClient", method = RequestMethod.POST)
    public String adminFindClientPost(HttpServletRequest request, Locale locale, Model model,
                                      @RequestParam(value = "number") String number) {
        model.addAttribute("check", "notwork");
        try {
            Contract contract = contractService.getContractByNumber(number);
            model.addAttribute("usr", contract);

        } catch (ContractNotFoundException ex) {
            model.addAttribute("usr", null);
        }
        return "admin/adminFindClient";
    }
}
