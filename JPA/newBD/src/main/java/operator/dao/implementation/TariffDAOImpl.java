package operator.dao.implementation;

import operator.dao.api.TariffDAO;
import operator.entities.Tariff;
import operator.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Access to tariff functionality
 */
@Repository("Tariff")
public class TariffDAOImpl extends GenericDAOImpl<Tariff, Integer> implements TariffDAO {
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Getting tariff entity by number
     * @param title entity for getting
     * @return tariff with adjusted number
     */
    public Tariff getTariffByTitle(String title) {
        try {
            Query query = entityManager.createQuery("select t from Tariff t where title=:title")
                    .setParameter("title", title);
            return (Tariff) query.getResultList().get(0);
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("Tariff with title " + title + " not found!", ex);
        }
    }
}

