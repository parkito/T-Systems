package DAO.Hibirnate;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.Iterator;
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
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("ADDED " + tar.toString());
    }

    public void getTariffsList() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String sql = "FROM Tariff";
            System.out.println(sql);
            List tariffs = session.createQuery(sql).list();
            for (Iterator iterator =
                 tariffs.iterator(); iterator.hasNext(); ) {
                Tariff tariff = (Tariff) iterator.next();
                System.out.print("id: " + tariff.getId());
                System.out.print("  title: " + tariff.getTitle());
            }
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}

