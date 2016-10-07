package operator.dao.api;

import operator.entities.TariffOption;
import operator.exceptions.OptionsForEntityNotGotException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public interface TariffOptionDAO extends GenericDAO<TariffOption, Integer> {

    public List<TariffOption> getAllTariffOptionsForTariff(int id) throws OptionsForEntityNotGotException;

    public List<TariffOption> getAllTariffOptionsForContract(int id) throws OptionsForEntityNotGotException;

    public List<TariffOption> getAllJointTariffOptions(int id) throws OptionsForEntityNotGotException;

    public List<TariffOption> getAllImpossibleTariffOptions(int id) throws OptionsForEntityNotGotException;

    public TariffOption getTariffOptionByTitle(String title);


}
