package services.logging;

import manipulating.ClientDAO;

/**
 * Created by Artyom Karnov on 8/22/16.
 * artyom-karnov@yandex.ru
 **/
public class Logging {
    ClientDAO clientDAO;

    public Logging() {
        clientDAO = new ClientDAO();
    }

    public static void main(String[] args) {
        Logging loging = new Logging();
        loging.signIn("ab@c.com", "214189"); //true
        loging.signIn("aa@c.com", "1234");//false
        loging.signIn("aac@c.com", "12345");//false
    }

    public void signIn(String eMail, String password) {
        if (clientDAO.isUserAuthenticated(eMail, password) == true)
            System.out.println("Welcome " + eMail);
        else System.out.println("Incorrect username or password");

    }

    public void signUp() {
        clientDAO.addClient("Ivan", "Ivanov", "5.2.1999", "8765456", "SPB", "ab@c.com", "214189");
    }

}
