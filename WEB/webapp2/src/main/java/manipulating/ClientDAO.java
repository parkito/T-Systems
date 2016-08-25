package manipulating;

import base.Client;

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
        clientDAO.addClient("Artyom", "Karnov", "08.02.1995", "data", "spb", "artyom @karnov.ru", "1122");
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


}
