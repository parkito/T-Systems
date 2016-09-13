package dao;

import exceptions.CustomDAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Artyom Karnov on 8/30/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Creating new factory for each servlet
 */
@WebListener
public class EntityFactory implements ServletContextListener {
    private static EntityManagerFactory emf;

    /**
     * Creating manager factory on servlet initialization
     * @param servletContextEvent entity for initialization
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        emf = Persistence.createEntityManagerFactory("operator");
    }

    /**
     * closing factories on servlet destroing
     * @param servletContextEvent entity for destroying
     */
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
