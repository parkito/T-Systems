package manipulating;

import base.Client;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class ClientDAO {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.addClient("Ivan", "Ivanov", "5.2.1999", "8765456", "SPB", "ab@c.com", "214189");
        clientDAO.addClient("Ivan", "Petrov", "5.6.1992", "8765456", "SPB", "aa@c.com", "124");
        clientDAO.addClient("Petya", "Ivanov", "8.3.1996", "8765456", "SPB", "aat@c.com", "12345");
    }

    public void addClient(String name, String secondName,
                          String birthdayData, String passport,
                          String adress, String eMail,
                          String password) {
        Client client = new Client(name, secondName, birthdayData,
                passport, adress, eMail, password);

        MainDAO.addEntetyToBase(client);
    }

    public static boolean userExisting(String eMail, String password) {
        String query = "SELECT * FROM Client WHERE email='" + eMail + "'";
        Client client = new Client();
        Object object = MainDAO.entityExisting(client, query);
        if (object != null) {
            client = (Client) object;
            if (client != null & client.getPassword().equals(password))
                return true;
            else return false;
        } else return false;
    }
}
