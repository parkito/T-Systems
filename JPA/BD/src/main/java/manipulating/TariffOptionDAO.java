package manipulating;


import base.TariffOption;

/**
 * Created by Artyom Karnov on 8/22/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffOptionDAO {
    public static void main(String[] args) {
        TariffOptionDAO tariffOptionDAO = new TariffOptionDAO();
        tariffOptionDAO.addTariffOption(1, "GB1", 25, null);
    }

    public void addTariffOption(int id, String title, double price, Double connectionPrice) {
        TariffOption tariffOption = new TariffOption(id, title, price, connectionPrice);
        MainDAO.addEntetyToBase(tariffOption);
    }
}
