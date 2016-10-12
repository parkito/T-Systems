package operator.services.api;

import operator.entities.Tariff;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Interface for TariffService
 */
public interface TariffService extends GenericService<Tariff, Integer> {

    /**
     * Getting tariff entity by title
     *
     * @param title entity for getting
     * @return tariff entity
     */
    public Tariff getTariffByTitle(String title);

    /**
     * Checking contract existing in base
     *
     * @param tariff entity for checking
     * @return true - if tariff exists, false if doesn't
     */
    public boolean isTariffExists(Tariff tariff);
}
