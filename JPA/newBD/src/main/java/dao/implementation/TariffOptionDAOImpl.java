package dao.implementation;

import dao.api.TariffOptionDAO;
import dao.api.UserDAO;
import entities.TariffOption;
import entities.User;
import exceptions.CustomDAOException;
import exceptions.OptionsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffOptionDAOImpl extends GenericDAOImpl<TariffOption, Integer> implements TariffOptionDAO {


    @Override
    public List<TariffOption> getAllTariffOptionsForTariff(int id) throws OptionsForEntityNotGotException {
        return null;
    }

    @Override
    public List<TariffOption> getAllContractOptions(int id) throws OptionsForEntityNotGotException {
        return null;
    }

    @Override
    public List<TariffOption> getAllJointTariffOptions(int id) throws OptionsForEntityNotGotException {
        return null;
    }

    @Override
    public List<TariffOption> getAllImpossibleTariffOptions(int id) throws OptionsForEntityNotGotException {
        return null;
    }
}
