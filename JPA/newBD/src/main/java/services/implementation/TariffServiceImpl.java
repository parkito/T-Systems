package services.implementation;


import dao.api.TariffDAO;
import entities.Tariff;
import exceptions.CustomDAOException;
import services.api.TariffService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffServiceImpl implements TariffService {
    private TariffDAO tariffDAO;

    @Override
    public void createEntity(Tariff tariff) throws CustomDAOException {
        this.tariffDAO.create(tariff);

    }

    @Override
    public Tariff getEntityById(Integer id) throws CustomDAOException {
        return this.tariffDAO.read(id);
    }

    @Override
    public void updateEntity(Tariff tariff) throws CustomDAOException {
        this.tariffDAO.update(tariff);

    }

    @Override
    public void deleteEntity(Tariff tariff) throws CustomDAOException {
        this.tariffDAO.delete(tariff);
    }

    /**
     * A method to get all tariffs from the database.
     * @return
     * @throws CustomDAOException
     */
    @Override
    public List<Tariff> getAll() throws CustomDAOException {
        return this.tariffDAO.getAll();

    }
}
