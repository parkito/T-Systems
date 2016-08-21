package com.tsystems.javaschool.jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class HelloWorld {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();
        List<UserEntity> usrs = em.createQuery("select a from UserEntity a", UserEntity.class).getResultList();
        for (UserEntity u : usrs) {
            System.out.println(u);
        }
        em.close();
        emf.close();
    }
}
