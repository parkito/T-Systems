package manipulating;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class MainDAO {
    //с открытие/Закрытием этих ресурсов проблемы  ---- ПОДУМАТЬ НАД РЕШЕНИЕМ ПРОБЛЕМЫ
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("operator");
    private static EntityManager em = emf.createEntityManager();

    public static List<Object> getEntitiesList(Object obj, String query) {
        Query nativeQuery = null;
        try {
            nativeQuery = em.createNativeQuery(query, obj.getClass());
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {
            return nativeQuery.getResultList();
        }
    }

    public static void addEntity(Object obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println(obj + " added");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        }
    }

    public static void updateEntity(Object object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            System.out.println(object + " updated");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        }
    }

    //Getting only one entity from db
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

    public static void deleteEntity(Object object) {
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
            System.out.println(object + " removed");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        }
    }

    public static void closeConnections() {
        em.close();
        emf.close();
    }

}
