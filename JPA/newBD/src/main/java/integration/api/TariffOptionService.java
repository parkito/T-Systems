package integration.api;


import entities.TariffOption;
import exceptions.OptionsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

public interface TariffOptionService extends GenericService<TariffOption, Integer> {

    public List<TariffOption> getAllTariffOptions(int id) throws OptionsForEntityNotGotException;

    public List<TariffOption> getAllTariffOptionForContract(int id) throws OptionsForEntityNotGotException;

    public List<TariffOption> getAllJoinedTariffOption(int id) throws OptionsForEntityNotGotException;

    public List<TariffOption> getAllImpossibleTariffOption(int id) throws OptionsForEntityNotGotException;
}
