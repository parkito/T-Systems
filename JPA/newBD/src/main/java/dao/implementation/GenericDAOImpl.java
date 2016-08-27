package dao.implementation;

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
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("operator");

    public GenericDAOImpl() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @PersistenceContext
    private EntityManager entityManager = emf.createEntityManager();

    @Override
    public void create(E entity) throws CustomDAOException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't created: " + entity, e);
        } finally {
            entityManager.close();
            emf.close();
        }
    }

    @Override
    public E read(K id) throws CustomDAOException {
        try {
            return (E) this.entityManager.find(daoType, id);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity " + id + " wasn't found", e);
        }
    }

    @Override
    public void update(E entity) throws CustomDAOException {
        try {
            entityManager.merge(entity);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't updated: " + entity, e);
        }

    }

    @Override
    public void delete(E entity) throws CustomDAOException {
        try {
            entityManager.remove(entityManager.merge(entity));
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't deleted: " + entity, e);
        }

    }

    @Override
    public List<E> getAll() throws CustomDAOException {
        try {
            return entityManager.createNamedQuery(daoType.getSimpleName() + ".getAll", daoType).getResultList();
        } catch (PersistenceException ex) {
            throw new CustomDAOException("Unable to get all entities of class " + daoType.getSimpleName(), ex);
        }
    }

    @Override
    public boolean isEntityExists(E entity) throws CustomDAOException {
        if (entityManager.createNamedQuery
                (daoType.getSimpleName() + ".getAll", daoType).getResultList().get(0) != null)
            return true;
        else return false;
    }
}

