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
        tariffDAO.addTariff("Base3");
    }

    public void addTariff(String title) {
        Tariff tariff = new Tariff(title);
        MainDAO.addEntetyToBase(tariff);
    }

    

    public Tariff getTariff(String title) {
        String query = "SELECT * FROM Tariff WHERE title='" + title + "'"; //Инъекция?? - NO
        Tariff tariff = new Tariff();
        tariff = (Tariff) MainDAO.getExistingEntity(tariff, query);
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
