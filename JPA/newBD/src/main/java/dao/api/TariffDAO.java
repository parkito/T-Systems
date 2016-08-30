package dao.api;

import entities.Tariff;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public interface TariffDAO extends GenericDAO<Tariff, Integer> {
    public Tariff getTariffByTitle(String title);
}
