package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.User;
import operator.services.api.ContractService;
import operator.services.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Karnov on 10/5/16.
 * artyom-karnov@yandex.ru
 **/
@Controller("RestService")
public class RestServiceController {
    @Autowired
    private TariffService tariffService;
    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/getRestInfo", method = RequestMethod.GET)
    public List<User> getContracts(@RequestParam(value = "contract") String contractTitle) {
        System.out.println(contractTitle);
        Tariff tariff = tariffService.getTariffByTitle("base");
        List<User> users = new ArrayList<>();
        for (Contract contract : contractService.getAll()) {
            if (contract.getTariff().equals(tariff)) {
                contract.getUser().setPassword("");
                users.add(contract.getUser());
            }
        }
        return users;
    }
}
