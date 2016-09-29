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
import operator.services.implementation.ContractServiceImpl;
import operator.services.implementation.TariffOptionServiceImpl;
import operator.services.implementation.TariffServiceImpl;
import operator.services.implementation.UserServiceImpl;
import operator.utils.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * A controllers to dispatch the queries of the employees.
 */
@Controller
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

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
        if (add == true) managerCases.addContractToBase(eMail, number);

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

        model.addAttribute("contracts", contracts);
        model.addAttribute("tariffService", tariffService);
        return "admin/adminChangeClientTariff";
    }

    @RequestMapping(value = "/adminChangeClient", method = RequestMethod.GET)
    public String adminChangeClient(HttpServletRequest req, Locale locale, Model model) {
        int count = 1;
        if (count == 1) {
            req.getSession(true).setAttribute("check", "start");
            count++;
        }
        User user = (User) req.getSession().getAttribute("currentUser");
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());

        model.addAttribute("contracts", contracts);
        model.addAttribute("tariffService", tariffService);
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
}
