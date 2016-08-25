package manipulating;

import base.Tariff;
import base.TariffOption;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

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

    public void getTariffList() {
        String query = "SELECT * FROM Tariff";
        List tariffList = MainDAO.getEntitiesList(new Tariff(), query);
        Tariff tariff = new Tariff();
        for (Object object : tariffList) {
            tariff = (Tariff) object;
            System.out.println(tariff.toString());
        }
    }

    public void getTariffList(PrintWriter out) {
        System.out.println("here");
        String query = "SELECT * FROM Tariff";
        List tariffList = MainDAO.getEntitiesList(new Tariff(), query);
        Tariff tariff = new Tariff();
        for (Object object : tariffList) {
            tariff = (Tariff) object;
            out.write(tariff.toString());
        }
    }

    public void addTariff(String title) {
        if (!isTariffExist(title)) {
            Tariff tariff = new Tariff(title);
            MainDAO.addEntity(tariff);
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

    public void addTariffOption(Tariff tariff, TariffOption tariffOption) {
        tariff.getTariffOptions().add(tariffOption);
    }

    public boolean tariffHasOption(Tariff tariff, TariffOption tariffOption) {
        return tariff.getTariffOptions().contains(tariffOption);
    }

    public Set<TariffOption> getTariffOtions(Tariff tariff) {
        System.out.println(tariff.getTitle() + ": ");
        for (TariffOption tariffOption : tariff.getTariffOptions()) {
            System.out.println("   " + tariffOption.getTitle());
        }
        return tariff.getTariffOptions();
    }


}