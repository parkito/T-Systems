package manipulating;

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
        tariffDAO.addTariff(2, "Base1");
        //Tariff tariff = tariffDAO.getTariff("Base1");
        //System.out.println(tariffDAO.isTariffPossible(tariff));
    }

    public void addTariff(int id, String title) {
        Tariff tariff = new Tariff(title);
        MainDAO.addEntetyToBase(tariff);
    }

    public void updateTariff(Tariff tariff, String newTitle) {
        Tariff newTariff = new Tariff(tariff.getId(), newTitle);
        MainDAO.updateEntetyInBase(tariff, newTariff);
    }

    public Tariff getTariff(String title) {
        String query = "SELECT * FROM Tariff WHERE title='" + title + "'"; //Инъекция?? - NO
        Tariff tariff = new Tariff();
        tariff = (Tariff) MainDAO.entityExisting(tariff, query);
        if (tariff == null) {
            tariff = new Tariff(0, "0");
        }
        return tariff;
    }

    public boolean isTariffPossible(Tariff tariff) {
        if (tariff.getId() == 0 && tariff.getTitle().equals("0"))
            return false;
        else return true;
    }

}
