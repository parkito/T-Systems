package services.implementation;


import dao.api.ContractDAO;
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
    private ContractDAO contractDAO;

    @Override
    public void createEntity(Contract contract) throws CustomDAOException {
        contractDAO.create(contract);
    }

    @Override
    public Contract getEntityById(Integer id) throws CustomDAOException {
        return contractDAO.read(id);
    }


    @Override
    public void updateEntity(Contract contract) throws CustomDAOException {
        contractDAO.update(contract);
    }


    @Override
    public void deleteEntity(Contract contract) throws CustomDAOException {
        contractDAO.delete(contract);
    }

    @Override
    public Contract getContractByNumber(String number) throws ContractNotFoundException {
        return contractDAO.getContractByNumber(number);
    }

    /**
     * A method to get all contracts.
     *
     * @return
     * @throws CustomDAOException
     */
    @Override
    public List<Contract> getAll() throws CustomDAOException {
        return contractDAO.getAll();
    }

    @Override
    public List<Contract> getAllContractsForUser(int id) throws ContractsForEntityNotGotException {
        return contractDAO.getAllUserContracts(id);
    }
}
