package dao.implementation;

import dao.EntityFactory;
import dao.api.GenericDAO;
import exceptions.CustomDAOException;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public abstract class GenericDAOImpl<E, K> implements GenericDAO<E, K> {
    protected Class<E> daoType;
    //For testing
//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("operator");
//    protected EntityManager entityManager = entityManagerFactory.createEntityManager();
    //For Servlets
    protected EntityManager entityManager = EntityFactory.createEntityManager();


    public GenericDAOImpl() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    /**
     * creating entity in base
     * @param entity
     * @throws CustomDAOException
     */
    @Override
    public void create(E entity) throws CustomDAOException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't created: " + entity, e);
        }
    }

    /**
     * reading entity from base
     * @param id
     * @return
     * @throws CustomDAOException
     */
    @Override
    public E read(K id) throws CustomDAOException {
        try {
            return (E) this.entityManager.find(daoType, id);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity " + id + " wasn't found", e);
        }
    }

    /**
     * refreshing entity in base
     * @param entity
     * @throws CustomDAOException
     */
    @Override
    public void update(E entity) throws CustomDAOException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't updated: " + entity, e);
        } catch (IllegalStateException e) {
            throw new CustomDAOException("Entity wasn't updated: " + entity, e);
        }

    }

    /**
     * deleting entity from base
     * @param entity
     * @throws CustomDAOException
     */
    @Override
    public void delete(E entity) throws CustomDAOException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(entity));
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't deleted: " + entity, e);
        }

    }

    /**
     * getting all same-type entities from base
     * @return
     * @throws CustomDAOException
     */
    @Override
    public List<E> getAll() throws CustomDAOException {
        try {
            return entityManager.createNamedQuery(daoType.getSimpleName() + ".getAll", daoType).getResultList();
        } catch (PersistenceException ex) {
            throw new CustomDAOException("Unable to get all entities of class " + daoType.getSimpleName(), ex);
        }
    }

}

