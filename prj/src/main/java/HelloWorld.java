/**
 * Created by Artyom Karnov on 8/17/16.
 * artyom-karnov@yandex.ru
 **/
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return "Hello World!";
    }
}
