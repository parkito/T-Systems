package DAO.Hibirnate;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/16/16.
 * artyom-karnov@yandex.ru
 **/
public class MainHibernate {
    public void getTariffOtions(String tariffTitle) {


        Session session = Factory.getSessionFactory().openSession();
        Query query = session.createSQLQuery("Select * from Tariffs");
        List<Object[]> list = query.list();

        for (int i = 0; i < 1; i++) {
            for (Object o : list.get(i)) {
                System.out.println(o);
            }
        }

    }
}
