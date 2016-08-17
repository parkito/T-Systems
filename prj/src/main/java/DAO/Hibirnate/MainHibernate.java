package DAO.Hibirnate;

import org.hibernate.*;
import org.hibernate.mapping.Map;

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
            String sql = "SELECT * FROM Tariffs";
            List tariffs = session.createSQLQuery(sql).addEntity(Tariff.class).list();
            for (Iterator iterator =
                 tariffs.iterator(); iterator.hasNext(); ) {
                Tariff tariff = (Tariff) iterator.next();
                System.out.print("id: " + tariff.getId());
                System.out.print("  title: " + tariff.getTitle());
                System.out.println();
            }
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void getTariffOtions() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String sql = "SELECT * FROM Tariffs_have_TariffOption";
            List tariffs = session.createSQLQuery(sql).addEntity(Tariff_has_TariffOption.class).list();
            for (Iterator iterator =
                 tariffs.iterator(); iterator.hasNext(); ) {
                Tariff_has_TariffOption tariff = (Tariff_has_TariffOption) iterator.next();
                System.out.print("tariff №: " + tariff.getTariffs_id());
                System.out.print(",  tariffOtion № : " + tariff.getTariffOption_id());
                System.out.println();
            }
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateTariff(long id, String title) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Tariff tariff =
                    (Tariff) session.get(Tariff.class, id);
            tariff.setTitle(title);
            session.update(tariff);
            transaction.commit();
            System.out.println("Changed on " + id + " succeed");
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteTariff(long id) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Tariff tariff =
                    (Tariff) session.get(Tariff.class, id);
            session.delete(id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

