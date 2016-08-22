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
//        Client client = new Client("Petya", "Ivanov", "8.3.1996", "8765456", "SPB", "aat@c.com", "12345");
//        clientDAO.deleteClient("aat@c.com");
        clientDAO.changePassword("aat@c.com","214189");
    }

    public void addClient(String name, String secondName,
                          String birthdayData, String passport,
                          String adress, String eMail,
                          String password) {
        Client client = new Client(name, secondName, birthdayData,
                passport, adress, eMail, password);
        if (!isUserExist(eMail))
            MainDAO.addEntetyToBase(client);
        else System.out.println("User " + eMail + " already exists");
    }

    public boolean isUserAuthenticated(String eMail, String password) {
        String query = "SELECT * FROM Client WHERE email='" + eMail + "'";
        Client client = new Client();
        Object object = MainDAO.getExistingEntity(client, query);
        if (object != null) {
            client = (Client) object;
            return (client != null & client.getPassword().equals(password)) ? true : false;
        } else return false;
    }

    public boolean isUserExist(String eMail) {
        String query = "SELECT * FROM Client WHERE email='" + eMail + "'";
        Client client = new Client();
        Object object = MainDAO.getExistingEntity(client, query);
        if (object != null) {
            client = (Client) object;
            return (client != null) ? true : false;
        } else return false;
    }

    public void deleteClient(String eMail) {
        Client client = null;
        if (isUserExist(eMail)) {
            client = getClient(eMail);
            MainDAO.deleteEntety(client);
        } else System.out.println("Client doesn't exists");
    }

    public void changePassword(String eMail, String newPassword) {
        Client client = getClient(eMail);
        client.setPassword(newPassword);
        MainDAO.updateEntetyInBase(client);
    }

    public Client getClient(String eMail) {
        String query = "SELECT * FROM Client WHERE email='" + eMail + "'"; //Инъекция?? - NO
        Client client = new Client();
        Object object = MainDAO.getExistingEntity(client, query);
        if (object != null)
            client = (Client) object;
        return client;

    }
}
