package manipulating;

import base.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.Date;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class ClientDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("operator");
    private EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.addClient(1, "Artyom", "Karnov", "8.2.1995", "8765456", "SPB", "siksmfp@yandex.ru", "2345");
    }

    public void addClient(int id, String name, String secondName,
                          String birthdayData, String passport,
                          String adress, String eMail,
                          String password) {
        Client client = new Client(id, name, secondName, birthdayData,
                passport, adress, eMail, password);

        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            System.out.println("Client added");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Fail");
        } finally {
            em.close();
            emf.close();
        }

    }
}
