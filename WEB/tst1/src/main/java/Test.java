/**
 * Created by Artyom Karnov on 8/29/16.
 * artyom-karnov@yandex.ru
 **/
public class Test {
    private String one;
    private String two;

    public Test() {
    }

    public Test(String one, String two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public String toString() {
        return "Test{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                '}';
    }
}
