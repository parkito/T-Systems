package dao.implementation;

import dao.api.GenericDAO;
import exceptions.CustomDAOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public abstract class GenericDAOImpl<E, K> implements GenericDAO<E, K> {
    protected Class<E> daoType;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(E entity) throws CustomDAOException {
        try {
            this.entityManager.persist(entity);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't created: " + entity, e);
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
            this.entityManager.merge(entity);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't updated: " + entity, e);
        }

    }

    @Override
    public void delete(E entity) throws CustomDAOException {
        try {
            this.entityManager.remove(entityManager.merge(entity));
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't deleted: " + entity, e);
        }

    }

    @Override
    public List<E> getAll() throws CustomDAOException {
        try {
            return this.entityManager.createNamedQuery(daoType.getSimpleName() + ".getAll", daoType).getResultList();
        } catch (PersistenceException ex) {
            throw new CustomDAOException("Unable to get all entities of class " + daoType.getSimpleName(), ex);
        }
    }


}

