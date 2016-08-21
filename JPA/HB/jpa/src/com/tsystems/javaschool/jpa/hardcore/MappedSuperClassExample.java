package com.tsystems.javaschool.jpa.hardcore;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MappedSuperClassExample {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();

        System.out.printf("Teacher is: %s", em.find(TeacherUser.class, 1L));
        System.out.printf("Teacher is: %s", em.find(JSMappedSuperUser.class, 1L));
        em.close();
        emf.close();
    }
}
