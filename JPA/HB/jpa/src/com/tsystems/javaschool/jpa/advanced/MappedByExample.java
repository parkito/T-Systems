package com.tsystems.javaschool.jpa.advanced;


import com.tsystems.javaschool.jpa.advanced.EntranceAttemp;
import com.tsystems.javaschool.jpa.advanced.Student;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MappedByExample {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();

        Address address = em.find(Address.class, 1L);
        Student student = address.getStudent();

        System.out.printf("Address is: %s\n", address);
        System.out.printf("Student mapped by Address: %s\n\n", student);

        Student anotherStudent = em.find(Student.class, 2L);
        System.out.printf("Wanna-to-move student is: %s\n\n", anotherStudent);
        address.setStudent(anotherStudent);

        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();

        Address newAddress = em.find(Address.class, 1L);
        System.out.printf("Updated student: %s\n", newAddress.getStudent());
        System.out.printf("Updated address: %s", newAddress);

        em.close();
        emf.close();
    }
}
