package com.tsystems.javaschool.jpa.advanced;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CascadeExample {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, 2L);
        Address address = student.getAddress();
        System.out.printf("Student is in context: %s\n",em.contains(student));
        System.out.printf("Address is in context: %s\n\n",em.contains(address));

        em.detach(student);

        System.out.printf("Student is in context: %s\n",em.contains(student));
        System.out.printf("Address is in context: %s\n",em.contains(address));

        em.close();
        emf.close();
    }
}
