package DAO.Hibirnate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/16/16.
 * artyom-karnov@yandex.ru
 **/
public class MainHibernate {
    public void addTariff(String tariffTitle) {
        Tariff tar = new Tariff(tariffTitle);
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(tar);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("ADDED " + tar.toString());


    }
}
