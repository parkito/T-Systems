package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

/**
 * Created by Artyom Karnov on 10/4/16.
 * artyom-karnov@yandex.ru
 **/
@Controller("Test")
public class Test {
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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String adminNewClientGet(HttpServletRequest request, Locale locale, Model model) {
        List<User> users = userService.getAll();
        Tariff tariff = tariffService.getTariffByTitle("base");
        for (User user : users) {
            for (Contract contract : user.getContracts()) {
                if (contract.getTariff().getTitle().equals("test"))
                    contract.setTariff(tariff);
            }
            userService.updateEntity(user);
        }
        tariffService.deleteEntity(tariffService.getTariffByTitle("test"));
        model.addAttribute("test", tariffService.getAll());
        return "admin/adminTest";
    }
}
