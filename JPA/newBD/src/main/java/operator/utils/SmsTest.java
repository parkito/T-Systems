package operator.utils;

/**
 * Created by Artyom Karnov on 9/30/16.
 * artyom-karnov@yandex.ru
 **/
public class SmsTest {
    public static void main(String[] args) {

        Smsc sms = new Smsc("parkito", "214189");
        sms.send_sms("+79516821928", "Message123", 1, "", "", 0, "artyom", "");
        System.out.println(sms.get_balance());

    }
}
