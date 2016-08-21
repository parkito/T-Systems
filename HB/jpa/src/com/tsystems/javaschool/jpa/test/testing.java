package com.tsystems.javaschool.jpa.test;

import com.tsystems.javaschool.jpa.basic.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
public class testing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        List<Tariff> tariffs = em.createQuery("select t from Tariff t", Tariff.class).getResultList();
        for (Tariff u : tariffs) {
            System.out.println(u);
        }
        em.close();
        emf.close();
    }
}

