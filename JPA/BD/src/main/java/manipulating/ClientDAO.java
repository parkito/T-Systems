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
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.addClient(1, "Ivan", "Ivanov", "8.3.1996", "8765456", "SPB", "a@b.com", "2345");
    }

    public void addClient(int id, String name, String secondName,
                          String birthdayData, String passport,
                          String adress, String eMail,
                          String password) {
        Client client = new Client(id, name, secondName, birthdayData,
                passport, adress, eMail, password);

        MainDAO.addEntetyToBase(client);
    }
}
