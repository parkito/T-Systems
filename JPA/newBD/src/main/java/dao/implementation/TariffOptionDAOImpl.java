package dao.implementation;

import dao.api.TariffOptionDAO;
import entities.Tariff;
import entities.TariffOption;
import exceptions.OptionsForEntityNotGotException;
import exceptions.UserNotFoundException;

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
 * Access to tariff option functionality
 */
public class TariffOptionDAOImpl extends GenericDAOImpl<TariffOption, Integer> implements TariffOptionDAO {
    /**
     * Getting tariff option list of adjusted tariff
     * @param id entity for getting
     * @return list of all tariff option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<TariffOption> getAllTariffOptionsForTariff(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select t.tariffId from Tariff t where t.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting tariff list for adjusted contract
     * @param id entity for getting
     * @return list of all contracts for adjusted contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<TariffOption> getAllTariffOptionsForContract(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select c.tariffOptions from Contract c where c.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for contract " + id + " not got", ex);
        }
    }

    /**
     * Getting all joint tariffs
     * @param id id for getting
     * @return list of joint option
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<TariffOption> getAllJointTariffOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.jointTogether from TariffOption opt where opt.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting all joint tariffs
     * @param id if for getting
     * @return list of impossible option
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<TariffOption> getAllImpossibleTariffOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.impossibleTogether from TariffOption opt where opt.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting tariff option by title
     * @param title entity for getting
     * @return title of tariff option
     */
    public TariffOption getTariffOptionByTitle(String title) {
        try {
            Query query = entityManager.createQuery("select t from TariffOption t where title=:title")
                    .setParameter("title", title);
            return (TariffOption) query.getResultList().get(0);
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("TariffOption with title " + title + " not found!", ex);
        }
    }
}
