package manipulating;

import base.Client;
import base.Tariff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/

/*
add +
isExists +
get +
delete +
specific

dependency

 */
public class TariffDAO {


    public static void main(String[] args) {
        TariffDAO tariffDAO = new TariffDAO();
        tariffDAO.deleteTariff("new");
    }

    public void addTariff(String title) {
        if (!isTariffExist(title)) {
            Tariff tariff = new Tariff(title);
            MainDAO.addEntityToBase(tariff);
        } else System.out.println("Tariff already exists");
    }

    public boolean isTariffExist(String title) {
        String query = "SELECT * FROM Tariff WHERE title='" + title + "'";
        Tariff tariff = new Tariff();
        Object object = MainDAO.getExistingEntity(tariff, query);
        if (object != null) {
            tariff = (Tariff) object;
            return (tariff != null) ? true : false;
        } else return false;
    }

    public Tariff getTariff(String title) {
        String query = "SELECT * FROM Tariff WHERE title='" + title + "'"; //Инъекция?? - NO
        Tariff tariff = new Tariff();
        Object object = MainDAO.getExistingEntity(tariff, query);
        if (object == null) {
            return new Tariff(0, "-");
        } else
            return (Tariff) object;
    }

    public void deleteTariff(String title) {
        Tariff tariff = null;
        if (isTariffExist(title)) {
            tariff = getTariff(title);
            MainDAO.deleteEntity(tariff);
        } else System.out.println("Tariff doesn't exists");
    }

    public boolean isTariffPossible(Tariff tariff) {
        if (tariff.getId() == 0 && tariff.getTitle().equals("-"))
            return false;
        else return true;
    }


}
