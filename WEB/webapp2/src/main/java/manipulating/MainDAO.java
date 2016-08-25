package manipulating;

import base.Client;
import base.Tariff;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class MainDAO {
    //с открытие/Закрытием этих ресурсов проблемы  ---- ПОДУМАТЬ НАД РЕШЕНИЕМ ПРОБЛЕМЫ
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

        }
    }

    public static void updateEntetyInBase(Object object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            System.out.println(object + " updated");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {

        }
    }


    public static Object getExistingEntity(Object obj, String query) {
        Object gottenObject = null;
        try {
            Query nativeQuery = em.createNativeQuery(query, obj.getClass());
            gottenObject = nativeQuery.getResultList().get(0);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {
            return gottenObject;
        }
    }

    public static void deleteEntety(Object object) {
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
            System.out.println(object + " removed");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {

        }
    }

}
