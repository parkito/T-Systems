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
     * creating tariff entity in base
     * @param tariff
     * @throws CustomDAOException
     */
    @Override
    public void createEntity(Tariff tariff) throws CustomDAOException {
        if (!isTariffExists(tariff))
            tariffDAO.create(tariff);
        else System.out.println("Tariff already exists");

    }

    /**
     * get tariff entity by id
     * @param id
     * @return tariff with adjusted id
     * @throws CustomDAOException
     */
    @Override
    public Tariff getEntityById(Integer id) throws CustomDAOException {
        return tariffDAO.read(id);
    }

    /**
     * update tariff entity in base
     * @param tariff
     * @throws CustomDAOException
     */
    @Override
    public void updateEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.update(tariff);

    }

    /**
     * delete tariff entity from base
     * @param tariff
     * @throws CustomDAOException
     */
    @Override
    public void deleteEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.delete(tariff);
    }

    /**
     * getting all tariff entities from base
     * @return list of all tariffs
     * @throws CustomDAOException
     */
    @Override
    public List<Tariff> getAll() throws CustomDAOException {
        return tariffDAO.getAll();

    }

    /**
     * checking contract existing in base
     * @param tariff
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
     * getting tariff entity by title
     * @param title
     * @return
     */
    @Override
    public Tariff getTariffByTitle(String title) {
        return tariffDAO.getTariffByTitle(title);
    }
}
