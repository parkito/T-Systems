package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class testing {
    public static void main(String[] args) {
        String sql = "SELECT\n" +
                "  Tariff.title       AS Tariff,\n" +
                "  TariffOption.title AS Options\n" +
                "FROM Tariff\n" +
                "  INNER JOIN Tariff_has_Option ON Tariff.id = Tariff_has_Option.Tariff_id\n" +
                "  INNER JOIN TariffOption ON Tariff_has_Option.Option_id = TariffOption.id\n" +
                "GROUP BY Tariff, Options";
        String sql2 = "SELECT * FROM Tariff";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query nativeQ = em.createNativeQuery(sql2, TariffEntity.class);
        List<TariffEntity> tariffs = nativeQ.getResultList();
        for (int i = 0; i < tariffs.size(); i++) {
            System.out.println(tariffs.get(i).getTitle() + ":");
            for (TariffOptionEntity tariffOptionEntity : tariffs.get(i).getTariffOptions()) {
                System.out.println(tariffOptionEntity.toString());
            }
        }


        em.close();
        emf.close();
    }

}
