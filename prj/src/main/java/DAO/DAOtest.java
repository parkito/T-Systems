package DAO;

/**
 * Created by Artyom Karnov on 8/16/16.
 * artyom-karnov@yandex.ru
 **/
public class DAOtest {
    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.getTariffOtions("Basic");
    }
}
