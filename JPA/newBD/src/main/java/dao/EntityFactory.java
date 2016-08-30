package dao;

import exceptions.CustomDAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/
public class EntityFactory implements ServletContextListener {
    private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        emf = Persistence.createEntityManagerFactory("operator");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new CustomDAOException("EntityManager isn't exist");
        }
        return emf.createEntityManager();
    }
}
