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
public class TariffOptionDAOImpl extends GenericDAOImpl<TariffOption, Integer> implements TariffOptionDAO {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Override
    public List<TariffOption> getAllTariffOptionsForTariff(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select t.tariffId from Tariff t where t.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    @Override
    public List<TariffOption> getAllTariffOptionsForContract(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select c.tariffOptions from Contract c where c.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for contract " + id + " not got", ex);
        }
    }

    @Override
    public List<TariffOption> getAllJointTariffOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.jointTogether from TariffOption opt where opt.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    @Override
    public List<TariffOption> getAllImpossibleTariffOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.impossibleTogether from TariffOption opt where opt.id=:id").setParameter("id", id);

            return (List<TariffOption>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

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
