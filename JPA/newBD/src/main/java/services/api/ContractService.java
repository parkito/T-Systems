package services.api;


import entities.Contract;
import exceptions.ContractNotFoundException;
import exceptions.ContractsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public interface ContractService extends GenericService<Contract, Integer> {

    public Contract getContractByNumber(String number) throws ContractNotFoundException;

    public List<Contract> getAllContractsForUser(int id) throws ContractsForEntityNotGotException;

}
