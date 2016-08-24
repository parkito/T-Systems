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
public class TariffDAO {


    public static void main(String[] args) {
        TariffDAO tariffDAO = new TariffDAO();
        tariffDAO.deleteTariff("new");
    }

    public void addTariff(String title) {
        if (!isTariffExist(title)) {
            Tariff tariff = new Tariff(title);
            MainDAO.addEntetyToBase(tariff);
        } else System.out.println("Tariff already exists");
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

    public boolean isTariffPossible(Tariff tariff) {
        if (tariff.getId() == 0 && tariff.getTitle().equals("0"))
            return false;
        else return true;
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

    public void deleteTariff(String title) {
        Tariff tariff = null;
        if (isTariffExist(title)) {
            tariff = getTariff(title);
            MainDAO.deleteEntety(tariff);
        } else System.out.println("Tariff doesn't exists");
    }
}
