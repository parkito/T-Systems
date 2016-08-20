package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class testing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
    }
}
