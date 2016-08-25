package manipulating;

import base.Contract;
import base.TariffOption;

import java.util.List;
import java.util.Set;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class ContractDAO {
    public static void main(String[] args) {
        ContractDAO contractDAO =new ContractDAO();
        contractDAO.addContract("12345");
        contractDAO.addContract("12344");
        contractDAO.addContract("12343");
        contractDAO.addContract("12342");
        MainDAO.closeConnections();

    }

    public void getContractList() {
        String query = "SELECT * FROM Contract";
        List contractList = MainDAO.getEntitiesList(new Contract(), query);
        Contract contract = new Contract();
        for (Object object : contractList) {
            contract = (Contract) object;
            System.out.println(contract.toString());
        }
    }

    public void addContract(String number) {
        if (!isContractExist(number)) {
            Contract contract = new Contract(number,"4");
            MainDAO.addEntity(contract);
        } else System.out.println("Contract already exists");
    }

    public boolean isContractExist(String number) {
        String query = "SELECT * FROM Contract WHERE number='" + number + "'";
        Contract contract = new Contract();
        Object object = MainDAO.getExistingEntity(contract, query);
        if (object != null) {
            contract = (Contract) object;
            return (contract != null) ? true : false;
        } else return false;
    }

    public Contract getContract(String number) {
        String query = "SELECT * FROM Contract WHERE number='" + number + "'"; //Инъекция?? - NO
        Contract contract = new Contract();
        Object object = MainDAO.getExistingEntity(contract, query);
        if (object == null) {
            return new Contract("-");
        } else
            return (Contract) object;
    }

    public void deleteContract(String number) {
        Contract contract = null;
        if (isContractExist(number)) {
            contract = getContract(number);
            MainDAO.deleteEntity(contract);
        } else System.out.println("Contract doesn't exists");
    }

    public boolean isContractPossible(Contract contract) {
        if (contract.getNumber().equals("-"))
            return false;
        else return true;
    }

    public void addContractOption(Contract contract, TariffOption contractOption) {
        if (!contractHasOption(contract, contractOption))
            contract.getTariffOptions().add(contractOption);
    }

    public boolean contractHasOption(Contract contract, TariffOption contractOption) {
        return contract.getTariffOptions().contains(contractOption);
    }

    public Set<TariffOption> getContractOtions(Contract contract) {
        System.out.println(contract.getNumber() + ": ");
        for (TariffOption contractOption : contract.getTariffOptions()) {
            System.out.println("   " + contractOption.getTitle());
        }
        return contract.getTariffOptions();
    }
}
