package operator.controllers;

import operator.entities.Contract;
import operator.entities.Tariff;
import operator.entities.User;
import operator.entities.UserDTO;
import operator.exceptions.CustomDAOException;
import operator.services.api.ContractService;
import operator.services.api.TariffService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    private final static Logger logger = Logger.getLogger(RestServiceController.class);

    @RequestMapping(value = "/getRestInfo", method = RequestMethod.GET)
    public
    @ResponseBody
    List<UserDTO> getContracts(@RequestParam(value = "contract") String contractTitle, HttpServletRequest req) {
        List<UserDTO> users = new ArrayList<>();
        User user = (User) req.getSession().getAttribute("currentUser");
        try {
            if (user.getAccessLevel().getAccessLevelId() != 3) {
                return null;
            }
            Tariff tariff = tariffService.getTariffByTitle(contractTitle);
            for (Contract contract : contractService.getAll()) {
                UserDTO userDTO = new UserDTO();
                if (contract.getTariff().equals(tariff)) {
                    userDTO.setUserId(String.valueOf(contract.getUser().getUserId()));
                    userDTO.setName(contract.getUser().getName());
                    userDTO.setSecondName(contract.getUser().getSecondName());
                    userDTO.setBalance(String.valueOf(contract.getUser().getBalance()));
                    userDTO.setEmail(contract.getUser().getEmail());
                    userDTO.setContracts(contract.getNumber());
                    users.add(userDTO);
                }
            }
        } catch (Exception ex) {
            logger.info(ex);
            return null;
        }
        return users;
    }
}
