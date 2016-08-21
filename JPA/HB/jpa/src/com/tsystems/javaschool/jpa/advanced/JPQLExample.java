package com.tsystems.javaschool.jpa.advanced;


import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JPQLExample {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPU");
        EntityManager em = emf.createEntityManager();

        //Native SQL
        Query nativeQuery = em.createNativeQuery("SELECT * FROM js_student WHERE first_name=?", Student.class);
        nativeQuery.setParameter(1, "Fedor");
        System.out.printf("Native query students:\n%s\n\n", nativeQuery.getResultList());

        //JPQL Query
        Query jpqlQuery = em.createQuery("SELECT s FROM Student s WHERE s.firstName=:firstName");
        jpqlQuery.setParameter("firstName", "Fedor");
        System.out.printf("JPQL query students:\n%s\n\n",jpqlQuery.getResultList());

        //JPQL Simple
        jpqlQuery = em.createQuery("SELECT s FROM Student s WHERE s.attemps.size>:attempsCount");
        jpqlQuery.setParameter("attempsCount", 1);
        System.out.printf("JPQL simple query students:\n%s\n\n", jpqlQuery.getResultList());


        //Native update
        em.getTransaction().begin();
        Query nativeUpdate = em.createNativeQuery("UPDATE js_schools SET id=1 WHERE id=1");
        nativeUpdate.executeUpdate();
        em.getTransaction().commit();

        //Criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> c = cb.createQuery(Student.class);
        Root<Student> student = c.from(Student.class);
        c.select(student)
                .where(cb.equal(student.get("firstName"), "Fedor"));
        System.out.printf("Criteria builder query :\n%s\n\n",em.createQuery(c).getResultList());


        em.close();
        emf.close();
    }
}
