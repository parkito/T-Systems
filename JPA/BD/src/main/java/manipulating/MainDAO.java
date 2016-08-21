package manipulating;

import base.Tariff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class MainDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("operator");
    private static EntityManager em = emf.createEntityManager();

    static public void addEntetyToBase(Object obj) {
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
}
