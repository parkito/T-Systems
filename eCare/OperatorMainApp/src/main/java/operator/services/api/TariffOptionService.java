package operator.services.api;


import operator.entities.TariffOption;
import operator.exceptions.OptionsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Interface for TariffOptionService
 */
public interface TariffOptionService extends GenericService<TariffOption, Integer> {

    /**
     * Getting tariff option for current tariff
     *
     * @param id id for getting
     * @return list of all option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllTariffOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting tariff option for current contract
     *
     * @param id if for getting
     * @return list of all options for contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllTariffOptionForContract(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting joint tariff options
     *
     * @param id id for getting
     * @return list of all joint options
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllJoinedTariffOption(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting impossible tariff options
     *
     * @param id id for getting
     * @return list of all impossible options
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<TariffOption> getAllImpossibleTariffOption(int id) throws OptionsForEntityNotGotException;
}
