package manipulating;

import base.Tariff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffDAO {


    public static void main(String[] args) {
        TariffDAO tariffDAO = new TariffDAO();
        tariffDAO.addTariff(2, "Base1");
    }

    public void addTariff(int id, String title) {
        Tariff tariff = new Tariff(id, title);
        MainDAO.addEntetyToBase(tariff);

    }

}
