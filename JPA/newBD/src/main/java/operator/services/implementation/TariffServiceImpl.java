package operator.services.implementation;


import operator.dao.api.TariffDAO;
import operator.dao.implementation.TariffDAOImpl;
import operator.entities.Tariff;
import operator.exceptions.CustomDAOException;
import operator.services.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
@Service("tariffService")
public class TariffServiceImpl implements TariffService {
    @Autowired
    private TariffDAO tariffDAO;

    /**
     * Creating tariff entity in base
     *
     * @param tariff entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void createEntity(Tariff tariff) throws CustomDAOException {
        if (!isTariffExists(tariff))
            tariffDAO.create(tariff);
        else System.out.println("Tariff already exists");

    }

    /**
     * Get tariff entity by id
     *
     * @param id id for getting
     * @return tariff with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public Tariff getEntityById(Integer id) throws CustomDAOException {
        return tariffDAO.read(id);
    }

    /**
     * Update tariff entity in base
     *
     * @param tariff entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.update(tariff);

    }

    /**
     * Delete tariff entity from base
     *
     * @param tariff entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.delete(tariff);
    }

    /**
     * Getting all tariff entities from base
     *
     * @return list of all tariffs
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public List<Tariff> getAll() throws CustomDAOException {
        return tariffDAO.getAll();

    }

    /**
     * Checking contract existing in base
     *
     * @param tariff entity for checking
     * @return true - if tariff exists, false if doesn't
     */
    @Override
    @Transactional
    public boolean isTariffExists(Tariff tariff) {
        try {
            return tariffDAO.getTariffByTitle(tariff.getTitle()) != null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Getting tariff entity by title
     *
     * @param title entity for getting
     * @return tariff entity
     */
    @Override
    @Transactional
    public Tariff getTariffByTitle(String title) {
        return tariffDAO.getTariffByTitle(title);
    }
}
