package services.api;

import entities.Tariff;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public interface TariffService extends GenericService<Tariff, Integer> {
    public Tariff getTariffByTitle(String title);
    public boolean isTariffExists(Tariff tariff);
}
