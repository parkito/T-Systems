package services.implementation;


import dao.api.ContractDAO;
import dao.implementation.ContractDAOImpl;
import entities.Contract;
import entities.User;
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

    @Override
    public void createEntity(Contract contract) throws CustomDAOException {
        if (!isContractExists(contract))
            contractDAO.create(contract);
        else System.out.println("Contract already exists");
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


    @Override
    public List<Contract> getAll() throws CustomDAOException {
        return contractDAO.getAll();
    }

    @Override
    public List<Contract> getAllContractsForUser(int id) throws ContractsForEntityNotGotException {
        return contractDAO.getAllUserContracts(id);
    }

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
