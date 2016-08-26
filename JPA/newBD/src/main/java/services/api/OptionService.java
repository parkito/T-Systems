package services.api;


import entities.TariffOption;
import exceptions.OptionsForEntityNotGotException;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

public interface OptionService extends GenericService<TariffOption, Integer> {

    public List<TariffOption> getAllOptionsForTariff(int id) throws OptionsForEntityNotGotException;

    public List<TariffOption> getAllOptionsForContract(int id) throws OptionsForEntityNotGotException;
    public List<TariffOption> getAllOptionsTogetherForOption(int id) throws OptionsForEntityNotGotException;
    public List<TariffOption> getAllOptionsIncompatibleForOption(int id) throws OptionsForEntityNotGotException;
}
