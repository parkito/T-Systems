package com.tsystems.javaschool.jpa.hardcore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by abulov on 20.03.14.
 */
public class EmbeddedExample {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();

        System.out.printf("Embedded student is are: %s\n",
                em.createQuery("SELECT tu FROM StudentWithEmbedded tu").getResultList());


        em.close();
        emf.close();
    }
}
