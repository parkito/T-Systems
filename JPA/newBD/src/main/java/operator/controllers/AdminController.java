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
import operator.utils.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


}
