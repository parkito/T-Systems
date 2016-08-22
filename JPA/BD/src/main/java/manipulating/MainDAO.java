package manipulating;

import base.Tariff;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class MainDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("operator");
    private static EntityManager em = emf.createEntityManager();

    public static void addEntetyToBase(Object obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println(obj + " added");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void updateEntetyInBase(Object oldObj, Object newObj) {
        try {
            em.getTransaction().begin();
            em.remove(oldObj);
            em.persist(newObj);
            em.getTransaction().commit();
            System.out.println(oldObj + " updated");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {
            em.close();
            emf.close();
        }
    }

    public static Object getEntety(Object obj, String query) {
        Object gottenObj = null;
        System.out.println(query);
        try {
            Query nativeQuery = em.createNativeQuery(query, obj.getClass());
            gottenObj = nativeQuery.getResultList().get(0);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {
            em.close();
            emf.close();
            return gottenObj;
        }


    }
}
