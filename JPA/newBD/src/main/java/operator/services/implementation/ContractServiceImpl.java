package operator.services.implementation;


import operator.dao.api.ContractDAO;
import operator.dao.implementation.ContractDAOImpl;
import operator.entities.Contract;
import operator.exceptions.ContractNotFoundException;
import operator.exceptions.ContractsForEntityNotGotException;
import operator.exceptions.CustomDAOException;
import operator.services.api.ContractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
@Service("contractService")
public class ContractServiceImpl implements ContractService {
    private ContractDAO contractDAO = new ContractDAOImpl();

    /**
     * Creating contract entity in base
     *
     * @param contract entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void createEntity(Contract contract) throws CustomDAOException {
        if (!isContractExists(contract))
            contractDAO.create(contract);
        else System.out.println("Contract already exists");
    }

    /**
     * Get contract entity by id
     *
     * @param id id for getting
     * @return contract with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public Contract getEntityById(Integer id) throws CustomDAOException {
        return contractDAO.read(id);
    }

    /**
     * Update contract entity in base
     *
     * @param contract entity updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(Contract contract) throws CustomDAOException {
        contractDAO.update(contract);
    }

    /**
     * Delete contract entity from base
     *
     * @param contract entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(Contract contract) throws CustomDAOException {
        contractDAO.delete(contract);
    }

    /**
     * Getting contract entity by number
     *
     * @param number number for getting
     * @return contract with adjusted number
     * @throws ContractNotFoundException if contract not found
     */
    @Override
    @Transactional
    public Contract getContractByNumber(String number) throws ContractNotFoundException {
        return contractDAO.getContractByNumber(number);
    }

    /**
     * Getting all contract entity from base
     *
     * @return list of all contracts
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public List<Contract> getAll() throws CustomDAOException {
        return contractDAO.getAll();
    }

    /**
     * Getting all contract for user
     *
     * @param id id for getting
     * @return list of all contracts for current user
     * @throws ContractsForEntityNotGotException if contract not found
     */
    @Override
    @Transactional
    public List<Contract> getAllContractsForUser(int id) throws ContractsForEntityNotGotException {
        return contractDAO.getAllUserContracts(id);
    }

    /**
     * Checking contract existing in base
     *
     * @param contract entity for checking
     * @return true - contract exists, false - contract doesn't exist
     */
    public boolean isContractExists(Contract contract) {
        try {
            return getContractByNumber(contract.getNumber()) != null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        } catch (ContractNotFoundException ex) {
            return false;
        }
    }
}
