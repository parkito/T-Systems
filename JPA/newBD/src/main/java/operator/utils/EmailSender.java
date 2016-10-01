package operator.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Artyom Karnov on 10/2/16.
 * artyom-karnov@yandex.ru
 **/
public class EmailSender {

    public static void send(String eMail, String user, String password) {
        String to = eMail;
        String from = "support@k-mobile.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Welcome to K-Mobile!");
            message.setContent("<h2>Dear, " + user + "!\n Welcome " +
                    "to K-Mobile!\n Your password: " + password + "</h2>", "text/html");
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
