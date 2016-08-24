package manipulating;


import base.Tariff;
import base.TariffOption;

/**
 * Created by Artyom Karnov on 8/22/16.
 * artyom-karnov@yandex.ru
 **/

/*
add +
isExists +
get
delete +
specific

dependency

 */
public class TariffOptionDAO {
    public static void main(String[] args) {
        TariffOptionDAO tariffOptionDAO = new TariffOptionDAO();
        tariffOptionDAO.addTariffOption("GB1", 25, null);
        tariffOptionDAO.addTariffOption("GB2", 50, 20.0);
        tariffOptionDAO.addTariffOption("call1", 30, null);
        tariffOptionDAO.addTariffOption("call2", 25, 50.0);
        tariffOptionDAO.addTariffOption("unlim", 100, 100.0);
    }

    public void addTariffOption(String title, double price, Double connectionPrice) {
        if (!isTariffOptionExist(title)) {
            TariffOption tariffOption = new TariffOption(title, price, connectionPrice);
            MainDAO.addEntityToBase(tariffOption);
        } else System.out.println("TariffOption already exists");
    }

    public boolean isTariffOptionExist(String title) {
        String query = "SELECT * FROM TariffOption WHERE title='" + title + "'";
        TariffOption tariffOption = new TariffOption();
        Object object = MainDAO.getExistingEntity(tariffOption, query);
        if (object != null) {
            tariffOption = (TariffOption) object;
            return (tariffOption != null) ? true : false;
        } else return false;
    }

    public TariffOption getTariffOption(String title) {
        String query = "SELECT * FROM TariffOption WHERE title='" + title + "'"; //Инъекция?? - NO
        TariffOption tariffOption = new TariffOption();
        Object object = MainDAO.getExistingEntity(tariffOption, query);
        if (object == null) {
            return new TariffOption("-", -1.0, -1.0);
        } else
            return (TariffOption) object;
    }

    public void deleteTariffOption(String title) {
        TariffOption tariffOption = null;
        if (isTariffOptionExist(title)) {
            tariffOption = getTariffOption(title);
            MainDAO.deleteEntity(tariffOption);
        } else System.out.println("TariffOption already doesn't exists");
    }

    public boolean isTariffOptionPossible(TariffOption tariffOption) {
        if (tariffOption.getId() == 0 & tariffOption.getTitle().equals("-"))
            return false;
        else return true;
    }
}
