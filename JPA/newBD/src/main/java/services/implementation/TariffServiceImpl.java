package services.implementation;


import dao.api.TariffDAO;
import dao.implementation.TariffDAOImpl;
import entities.Tariff;
import entities.User;
import exceptions.CustomDAOException;
import services.api.TariffService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffServiceImpl implements TariffService {
    private TariffDAO tariffDAO = new TariffDAOImpl();

    @Override
    public void createEntity(Tariff tariff) throws CustomDAOException {
        if (!isTariffExists(tariff))
            tariffDAO.create(tariff);
        else System.out.println("Tariff already exists");

    }

    @Override
    public Tariff getEntityById(Integer id) throws CustomDAOException {
        return tariffDAO.read(id);
    }

    @Override
    public void updateEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.update(tariff);

    }

    @Override
    public void deleteEntity(Tariff tariff) throws CustomDAOException {
        tariffDAO.delete(tariff);
    }

    @Override
    public List<Tariff> getAll() throws CustomDAOException {
        return tariffDAO.getAll();

    }
    @Override
    public boolean isTariffExists(Tariff tariff) {
        try {
            return tariffDAO.getTariffByTitle(tariff.getTitle()) != null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
    @Override
    public Tariff getTariffByTitle(String title) {
        return tariffDAO.getTariffByTitle(title);
    }
}
