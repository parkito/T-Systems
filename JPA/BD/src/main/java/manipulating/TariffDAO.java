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
public class TariffDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("operator");
    private EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        TariffDAO tariffDAO = new TariffDAO();
        tariffDAO.addTariff(1, "Base");
    }

    public void addTariff(int id, String title) {
        Tariff tariff = new Tariff(id, title);
        try {
            em.getTransaction().begin();
            em.persist(tariff);
            em.getTransaction().commit();
            System.out.println("Tariff added");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {
            em.close();
            emf.close();
        }
    }

}
