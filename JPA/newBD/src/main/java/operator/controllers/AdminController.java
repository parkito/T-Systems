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
            req.getSession(true).setAttribute("emailStat", "Error");
            add = false;
        } else {
            req.getSession(true).setAttribute("emailStat", "OK");
        }

        if (managerCases.isNumberExists(number) || number.equals("")) {
            req.getSession(true).setAttribute("numberStat", "Error");
            add = false;
        } else {
            req.getSession(true).setAttribute("numberStat", "OK");
        }
        if (add == true) managerCases.addContractToBase(eMail, number);

        return "admin/adminNewContract";
    }

//    @RequestMapping(value = "/adminChangeClientTariff", method = RequestMethod.GET)
//    public String adminChangeClientTariff(HttpServletRequest re, Locale locale, Model model) {
//         int count = 1;
//        if (count == 1) {
//            req.getSession(true).setAttribute("check", "start");
//            count++;
//        }
//
//
//        String eMail = (String) req.getSession(true).getAttribute("eMail");
//        String userName = (String) req.getSession(true).getAttribute("userName");
//        User user = userService.getUserByEMAil(eMail);
//        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
//
//        req.getSession(true).setAttribute("contracts", contracts);
//        req.getSession().setAttribute("tariffService", tariffService);
//        req.getRequestDispatcher("/WEB-INF/admin/adminChangeClientTariff.jsp").forward(req, resp);
//        return "admin/adminChangeClientTariff";
//    }

}
