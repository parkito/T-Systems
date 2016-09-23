package operator.dao.api;

import operator.entities.Contract;
import operator.exceptions.ContractNotFoundException;
import operator.exceptions.ContractsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public interface ContractDAO extends GenericDAO<Contract, Integer> {

    public Contract getContractByNumber(String number) throws ContractNotFoundException;

    public List<Contract> getAllUserContracts(int id) throws ContractsForEntityNotGotException;

}
