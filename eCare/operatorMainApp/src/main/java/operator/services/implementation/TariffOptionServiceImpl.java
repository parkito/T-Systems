package operator.services.implementation;


import operator.dao.api.TariffOptionDAO;
import operator.entities.TariffOption;
import operator.exceptions.CustomDAOException;
import operator.exceptions.OptionsForEntityNotGotException;
import operator.services.api.TariffOptionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
@Service("tariffOptionService")
public class TariffOptionServiceImpl implements TariffOptionService {
    private final static Logger logger = Logger.getLogger(ContractServiceImpl.class);

    @Autowired
    private TariffOptionDAO optionDAO;

    /**
     * Creating tariff option entity in base
     *
     * @param option entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void createEntity(TariffOption option) throws CustomDAOException {
        if (!isTariffOptionExists(option))
            optionDAO.create(option);
    }

    /**
     * Getting tariff option entity by id
     *
     * @param id id for getting
     * @return tariff option with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public TariffOption getEntityById(Integer id) throws CustomDAOException {
        return optionDAO.read(id);
    }

    /**
     * Update tariff option entity in base
     *
     * @param option entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(TariffOption option) throws CustomDAOException {
        optionDAO.update(option);
    }

    /**
     * Deleting tariff option entity from base
     *
     * @param option entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(TariffOption option) throws CustomDAOException {
        optionDAO.delete(option);
    }

    /**
     * getting all tariff option entity from base
     *
     * @return list of all tariff option
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Transactional
    public List<TariffOption> getAll() throws CustomDAOException {
        return optionDAO.getAll();
    }

    /**
     * Getting tariff option for current tariff
     *
     * @param id id for getting
     * @return list of all option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<TariffOption> getAllTariffOptions(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllTariffOptionsForTariff(id);
    }

    /**
     * Getting tariff option for current contract
     *
     * @param id if for getting
     * @return list of all options for contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<TariffOption> getAllTariffOptionForContract(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllTariffOptionsForContract(id);
    }

    /**
     * Getting joint tariff options
     *
     * @param id id for getting
     * @return list of all joint options
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<TariffOption> getAllJoinedTariffOption(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllJointTariffOptions(id);
    }

    /**
     * Getting impossible tariff options
     *
     * @param id id for getting
     * @return list of all impossible options
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<TariffOption> getAllImpossibleTariffOption(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllImpossibleTariffOptions(id);
    }

    /**
     * Checking tariff existing in base
     *
     * @param tariffOption entity for checking
     * @return true - if option exists, false - if doesn't
     */
    public boolean isTariffOptionExists(TariffOption tariffOption) {
        try {
            return optionDAO.getTariffOptionByTitle(tariffOption.getTitle()) != null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            logger.error(e);
            return false;
        }
    }

}
