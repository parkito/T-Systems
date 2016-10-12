package operator.services.api;


import operator.entities.Contract;
import operator.exceptions.ContractNotFoundException;
import operator.exceptions.ContractsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Interface for ContractService
 */
public interface ContractService extends GenericService<Contract, Integer> {

    /**
     * Getting contract entity by number
     *
     * @param number number for getting
     * @return contract with adjusted number
     * @throws ContractNotFoundException if contract not found
     */
    public Contract getContractByNumber(String number) throws ContractNotFoundException;

    /**
     * Getting all contract for user
     *
     * @param id id for getting
     * @return list of all contracts for current user
     * @throws ContractsForEntityNotGotException if contract not found
     */
    public List<Contract> getAllContractsForUser(int id) throws ContractsForEntityNotGotException;

}
