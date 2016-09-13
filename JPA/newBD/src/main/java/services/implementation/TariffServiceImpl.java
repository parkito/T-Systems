package services.implementation;


import dao.api.TariffDAO;
import dao.implementation.TariffDAOImpl;
import entities.Tariff;
import exceptions.CustomDAOException;
import services.api.TariffService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffServiceImpl implements TariffService {
    private TariffDAO tariffDAO = new TariffDAOImpl();

    /**
     * Creating tariff entity in base
     * @param tariff entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    public void createEntity(Tariff tariff) throws CustomDAOException {
        if (!isTariffExists(tariff))
            tariffDAO.create(tariff);
        else System.out.println("Tariff already exists");

    }

    /**
     * Get tariff entity by id
     * @param id id for getting
     * @return tariff with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    public Tariff getEntityById(Integer id) throws CustomDAOException {
        return tariffDAO.read(id);
    }

    /**
     * Update tariff entity in base
     * @param tariff entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    public void updateEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.update(tariff);

    }

    /**
     * Delete tariff entity from base
     * @param tariff entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    public void deleteEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.delete(tariff);
    }

    /**
     * Getting all tariff entities from base
     * @return list of all tariffs
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    public List<Tariff> getAll() throws CustomDAOException {
        return tariffDAO.getAll();

    }

    /**
     * Checking contract existing in base
     * @param tariff entity for checking
     * @return true - if tariff exists, false if doesn't
     */
    @Override
    public boolean isTariffExists(Tariff tariff) {
        try {
            return tariffDAO.getTariffByTitle(tariff.getTitle()) != null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Getting tariff entity by title
     * @param title entity for getting
     * @return tariff entity
     */
    @Override
    public Tariff getTariffByTitle(String title) {
        return tariffDAO.getTariffByTitle(title);
    }
}
