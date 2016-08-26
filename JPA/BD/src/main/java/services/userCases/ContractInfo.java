package services.userCases;

import base.Contract;
import base.TariffOption;
import manipulating.ClientDAO;
import manipulating.ContractDAO;
import manipulating.MainDAO;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class ContractInfo {
    public static void main(String[] args) {
        ContractDAO contractDAO = new ContractDAO();
        contractDAO.addContract("214189");
//        ClientDAO clientDAO = new ClientDAO();
//        clientDAO.getClient("a@b.ru").getContracts().add(contractDAO.getContract("214189"));
//        MainDAO.closeConnections();
        ContractInfo contractInfo = new ContractInfo();
        contractInfo.getContractInfo(contractDAO.getContract("214189"));
    }

    public void getContractInfo(Contract contract) {
        System.out.println(contract);
        System.out.println("Connetced options");
        for (TariffOption tariffOption : contract.getTariffOptions()) {
            System.out.println(tariffOption);
        }

    }
}
