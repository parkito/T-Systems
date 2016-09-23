package operator.dao.implementation;

import operator.dao.api.ContractDAO;
import operator.entities.Contract;
import operator.exceptions.ContractNotFoundException;
import operator.exceptions.ContractsForEntityNotGotException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/


/**
 * Contract operations
 */
public class ContractDAOImpl extends GenericDAOImpl<Contract, Integer> implements ContractDAO {
    /**
     * Get contract by number
     * @param number entity for getting
     * @return contract with adjusted number
     * @throws ContractNotFoundException if contract not found
     */
    @Override
    public Contract getContractByNumber(String number) throws ContractNotFoundException {
        try {
            return (Contract) entityManager.createQuery("select c from Contract c where c.number=:number")
                    .setParameter("number", number).getSingleResult();
        } catch (PersistenceException e) {
            throw new ContractNotFoundException("Contract " + number + " wasn't gotten", e);
        }
    }

    /**
     * Get all contracts that user has
     * @param id id for getting
     * @return list of all contracts for adjusted user
     * @throws ContractsForEntityNotGotException if contract not found
     */
    @Override
    public List<Contract> getAllUserContracts(int id) throws ContractsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select u.contracts from User u where u.id=:id")
                    .setParameter("id", id);
            return (List<Contract>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new ContractsForEntityNotGotException("Contracts for user " + id + " wasn't gotten", ex);
        }
    }

}
