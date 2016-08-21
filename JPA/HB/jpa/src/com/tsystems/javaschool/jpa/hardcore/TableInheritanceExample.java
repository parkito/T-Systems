package com.tsystems.javaschool.jpa.hardcore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TableInheritanceExample {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();

        System.out.printf("Teachers are: %s\n",
                em.createQuery("SELECT tu FROM TeacherInheritedUser tu").getResultList());

        System.out.printf("Admins are: %s",
                em.createQuery("SELECT tu FROM AdminInheritedUser tu").getResultList());

        em.close();
        emf.close();
    }

}
