package operator.dao.api;

import operator.entities.TariffOption;
import operator.exceptions.OptionsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Interface for TariffOptionDAO
 */
public interface TariffOptionDAO extends GenericDAO<TariffOption, Integer> {

    /**
     * Getting tariff option list of adjusted tariff
     *
     * @param id entity for getting
     * @return list of all tariff option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllTariffOptionsForTariff(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting tariff list for adjusted contract
     *
     * @param id entity for getting
     * @return list of all contracts for adjusted contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllTariffOptionsForContract(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting all joint tariffs
     *
     * @param id id for getting
     * @return list of joint option
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllJointTariffOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting all joint tariffs
     *
     * @param id if for getting
     * @return list of impossible option
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllImpossibleTariffOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting tariff option by title
     *
     * @param title entity for getting
     * @return title of tariff option
     */
    public TariffOption getTariffOptionByTitle(String title);


}
