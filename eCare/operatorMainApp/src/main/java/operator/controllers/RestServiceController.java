package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.UserDTO;
import operator.services.api.ContractService;
import operator.services.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public
    @ResponseBody
    List<UserDTO> getContracts(@RequestParam(value = "contract") String contractTitle) {
        List<UserDTO> users = new ArrayList<>();
        try {
            UserDTO userDTO = new UserDTO();
            Tariff tariff = tariffService.getTariffByTitle(contractTitle);
            for (Contract contract : contractService.getAll()) {
                if (contract.getTariff().equals(tariff)) {
                    userDTO.setUserId(String.valueOf(contract.getUser().getUserId()));
                    userDTO.setName(contract.getUser().getName());
                    userDTO.setSecondName(contract.getUser().getSecondName());
                    userDTO.setBirthdayData(contract.getUser().getBirthdayData());
                    userDTO.setPassport(contract.getUser().getPassport());
                    userDTO.setAdress(contract.getUser().getAdress());
                    userDTO.setBalance(String.valueOf(contract.getUser().getBalance()));
                    userDTO.setEmail(contract.getUser().getEmail());
                    userDTO.setContracts(contract.getNumber());
                    users.add(userDTO);
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return users;
    }
}
