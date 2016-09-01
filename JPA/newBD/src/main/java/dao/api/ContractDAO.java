package dao.api;

import entities.Contract;
import exceptions.ContractNotFoundException;
import exceptions.ContractsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public interface ContractDAO extends GenericDAO<Contract, Integer> {

    public Contract getContractByNumber(String number) throws ContractNotFoundException;

    public List<Contract> getAllUserContracts(int id) throws ContractsForEntityNotGotException;

}
