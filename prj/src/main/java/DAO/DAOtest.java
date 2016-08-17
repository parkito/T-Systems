package DAO;

/**
 * Created by Artyom Karnov on 8/16/16.
 * artyom-karnov@yandex.ru
 **/
public class DAOtest {
    public static void main(final String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.getTariffOptions("Basic");
//        MainHibernate hiber = new MainHibernate();
//        //hiber.addTariff("novetly");
////        hiber.getTariffsList();
////        hiber.addTariff("newset");
//        //hiber.updateTariff(9, "newest1");
////        hiber.getTariffOtions();
//        hiber.test();
    }
}
