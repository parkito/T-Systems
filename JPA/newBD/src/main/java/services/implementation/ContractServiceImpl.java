package services.implementation;


import dao.api.ContractDAO;
import dao.implementation.ContractDAOImpl;
import entities.Contract;
import exceptions.ContractNotFoundException;
import exceptions.ContractsForEntityNotGotException;
import exceptions.CustomDAOException;
import services.api.ContractService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

public class ContractServiceImpl implements ContractService {
    private ContractDAO contractDAO = new ContractDAOImpl();

    /**
     *creating contract entity in base
     * @param contract
     * @throws CustomDAOException
     */
    @Override
    public void createEntity(Contract contract) throws CustomDAOException {
        if (!isContractExists(contract))
            contractDAO.create(contract);
        else System.out.println("Contract already exists");
    }

    /**
     * get contract entity by id
     * @param id
     * @return contract with adjusted id
     * @throws CustomDAOException
     */
    @Override
    public Contract getEntityById(Integer id) throws CustomDAOException {
        return contractDAO.read(id);
    }

    /**
     * update contract entity in base
     * @param contract
     * @throws CustomDAOException
     */
    @Override
    public void updateEntity(Contract contract) throws CustomDAOException {
        contractDAO.update(contract);
    }

    /**
     * delete contract entity from base
     * @param contract
     * @throws CustomDAOException
     */
    @Override
    public void deleteEntity(Contract contract) throws CustomDAOException {
        contractDAO.delete(contract);
    }

    /**
     * getting contract entity by number
     * @param number
     * @return contract with adjusted number
     * @throws ContractNotFoundException
     */
    @Override
    public Contract getContractByNumber(String number) throws ContractNotFoundException {
        return contractDAO.getContractByNumber(number);
    }

    /**
     * getting all contract entity from base
     * @return list of all contracts
     * @throws CustomDAOException
     */
    @Override
    public List<Contract> getAll() throws CustomDAOException {
        return contractDAO.getAll();
    }

    /**
     * getting all contract for user
     * @param id
     * @return list of all contracts for current user
     * @throws ContractsForEntityNotGotException
     */
    @Override
    public List<Contract> getAllContractsForUser(int id) throws ContractsForEntityNotGotException {
        return contractDAO.getAllUserContracts(id);
    }

    /**
     * checking contract existing in base
     * @param contract
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
