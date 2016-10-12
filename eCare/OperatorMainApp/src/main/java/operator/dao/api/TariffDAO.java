package operator.dao.api;

import operator.entities.Tariff;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Interface for TariffDAO
 */
public interface TariffDAO extends GenericDAO<Tariff, Integer> {
    /**
     * Getting tariff entity by number
     *
     * @param title entity for getting
     * @return tariff with adjusted number
     */
    public Tariff getTariffByTitle(String title);
}
