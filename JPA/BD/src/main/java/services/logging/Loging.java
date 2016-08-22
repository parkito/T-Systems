package services.logging;

import manipulating.ClientDAO;

/**
 * Created by Artyom Karnov on 8/22/16.
 * artyom-karnov@yandex.ru
 **/
public class Loging {
    public static void main(String[] args) {
        Loging loging = new Loging();
        loging.signIn("ab@c.com", "214189"); //true
        loging.signIn("aa@c.com", "1234");//false
        loging.signIn("aac@c.com", "12345");//false
    }

    public void signIn(String eMail, String password) {
        System.out.println(ClientDAO.userExisting(eMail, password));
    }

    public void signUp() {
    }

}
