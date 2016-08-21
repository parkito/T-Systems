package com.tsystems.javaschool.jpa.advanced;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ValidationExample {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();

        Student invalidStudent = new Student();
        invalidStudent.setLastName("aaa");
        em.getTransaction().begin();
        em.persist(invalidStudent);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
