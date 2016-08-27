package services.implementation;


import dao.api.TariffOptionDAO;
import entities.TariffOption;
import exceptions.CustomDAOException;
import exceptions.OptionsForEntityNotGotException;
import services.api.TariffOptionService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffOptionServiceImpl implements TariffOptionService {
    private TariffOptionDAO optionDAO;

    @Override
    public void createEntity(TariffOption option) throws CustomDAOException {
        this.optionDAO.create(option);
    }

    @Override
    public TariffOption getEntityById(Integer id) throws CustomDAOException {
        return this.optionDAO.read(id);
    }

    @Override
    public void updateEntity(TariffOption option) throws CustomDAOException {
        this.optionDAO.update(option);
    }

    @Override
    public void deleteEntity(TariffOption option) throws CustomDAOException {
        this.optionDAO.delete(option);
    }


    public List<TariffOption> getAll() throws CustomDAOException {
        return optionDAO.getAll();
    }


    @Override
    public List<TariffOption> getAllTariffOptions(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllTariffOptionsForTariff(id);
    }

    @Override
    public List<TariffOption> getAllTariffOptionForContract(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllContractOptions(id);
    }

    @Override

    public List<TariffOption> getAllJoinedTariffOption(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllJointTariffOptions(id);
    }

    @Override
    public List<TariffOption> getAllImpossibleTariffOption(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllImpossibleTariffOptions(id);
    }
}