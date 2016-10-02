package operator.integration;

import operator.entities.TariffOption;
import operator.services.api.TariffOptionService;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that handles the validation of the contracts creation.
 */
@Service("contractValidator")
public class ContractValidator {
    @Autowired
    private TariffOptionService optionService;
    @Autowired
    private UserService userService;

    public List validateOptions(int[] array, List<Exception> exceptionsList, int userId) {
        List<TariffOption> optionsTogether;
        List<TariffOption> optionsIncompatible;
        List<Integer> temporaryList = new ArrayList<>();
        List<TariffOption> optionList = new ArrayList<>();
        for (int x : array) {
            temporaryList.add(x);
        }
        for (Integer x : temporaryList) { // for each option
            TariffOption currentOption = optionService.getEntityById(x);
            optionList.add(currentOption); //we add it to the final list
            optionsTogether = currentOption.getjointTogether(); // we get a list of necessary options
            if (!optionsTogether.isEmpty()) {
                for (TariffOption necessary : optionsTogether) { //for each option from the together list we check whether it was checked
                    if (!temporaryList.contains(necessary.getTariffOptionId())) { //if it wasn't
                        exceptionsList.add(new Exception("You didn't select the " + necessary.getTitle() + " option, but it was necessary for the option " + currentOption.getTitle()));
                    }
                }
            }
            optionsIncompatible = currentOption.getimpossibleTogether(); //we get a list of incompatible options
            if (!optionsIncompatible.isEmpty()) {
                for (TariffOption incompatible : optionsIncompatible) {
                    if (temporaryList.contains(incompatible.getTariffOptionId())) {
                        exceptionsList.add(new Exception("You selected the " + incompatible.getTitle() + " option, but it can't be selected with the option " + currentOption.getTitle()));
                    }
                }
            }
        }
        if (exceptionsList.isEmpty() && userId != 0) {
            //a check for balance - is the required sum on the account
            double balance = balanceCheck(userId, optionList);
            if (balance < 0) {
                exceptionsList.add(new Exception("You do not have enough money on your account to perform the necessary action. Please refill your balance in the amount of " + (0 - balance) + " roubles."));
            }
        }
        List list = new ArrayList<>();
        Collections.addAll(list, optionList, exceptionsList);
        return list;
    }

    public double balanceCheck(int userId, List<TariffOption> optionList) {
        double balance = userService.getEntityById(userId).getBalance();
        for (TariffOption x : optionList) {
            balance -= x.getConnectionPrice();
        }
        return balance;
    }

    public void priceCheck(int price, String priceName) throws Exception {
        if (price > 400000) throw new Exception(String.format("The %s is too high!", priceName));
        if (price < 0) throw new Exception(String.format("The %s must be > 0!", priceName));
    }
}
