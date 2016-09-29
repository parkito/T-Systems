package operator.security;

import operator.services.api.ContractService;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Artyom Karnov on 9/29/16.
 * artyom-karnov@yandex.ru
 **/
@Controller
public class Checking {
    @Autowired
    private ContractService contractService;
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        Checking checking = new Checking();
        checking.run();
    }

    public void run() {
        System.out.println(userService.getAll());
    }
}
