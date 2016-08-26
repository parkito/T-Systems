package manipulating;

import base.Client;
import base.Contract;
import base.Tariff;
import base.TariffOption;
import org.hibernate.validator.internal.util.Contracts;

import java.util.Set;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/

/*
add +
isExists +
get +
delete +
specific

dependency

 */
public class ClientDAO {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.addClient("Ivan", "Ivanov", "08.01.2016", "passport1", "sbp", "a@b.ru", "123");
        clientDAO.addClient("Ivan", "Petrov", "08.01.2000", "passport2", "sbp", "a@t.ru", "1236");
        clientDAO.addClient("Petr", "Ivanov", "08.01.2016", "passport3", "sbp", "a@d.ru", "1236");
        clientDAO.addClient("Sidor", "Ivanov", "08.01.2016", "passport4", "msk", "a@c.ru", "123");
        MainDAO.closeConnections();

    }

    public void addClient(String name, String secondName,
                          String birthdayData, String passport,
                          String adress, String eMail,
                          String password) {
        Client client = new Client(name, secondName, birthdayData,
                passport, adress, eMail, password);
        if (!isUserExist(eMail))
            MainDAO.addEntity(client);
        else System.out.println("User " + eMail + " already exists");
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

    public Client getClient(String eMail) {
        String query = "SELECT * FROM Client WHERE email='" + eMail + "'"; //Инъекция?? - NO
        Client client = new Client();
        Object object = MainDAO.getExistingEntity(client, query);
        if (object != null)
            client = (Client) object;
        return client;
    }

    public void deleteClient(String eMail) {
        Client client = null;
        if (isUserExist(eMail)) {
            client = getClient(eMail);
            MainDAO.deleteEntity(client);
        } else System.out.println("Client doesn't exists");
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

    public void changePassword(String eMail, String newPassword) {
        Client client = getClient(eMail);
        client.setPassword(newPassword);
        MainDAO.updateEntity(client);
    }

    public Set<Contract> getContracts(Client client) {
        System.out.println(client.geteMail() + ": ");
        for (Contract contract : client.getContracts()) {
            System.out.println("   " + contract.getNumber());
        }
        return client.getContracts();
    }

    public void addContract(Client client, Contract contract) {
        if (!clientHasContract(client, contract)) {
            client.getContracts().add(contract);
            MainDAO.updateEntity(client);
        }
    }

    public boolean clientHasContract(Client client, Contract contract) {
        return client.getContracts().contains(contract);
    }

    public void setAdmin(Client client) {
        client.setStatus("Admin");
    }


}
