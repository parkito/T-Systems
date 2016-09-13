package dao.implementation;

import dao.api.TariffDAO;
import entities.Tariff;
import entities.User;
import exceptions.CustomDAOException;
import exceptions.UserNotFoundException;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/


public class TariffDAOImpl extends GenericDAOImpl<Tariff, Integer> implements TariffDAO {
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

