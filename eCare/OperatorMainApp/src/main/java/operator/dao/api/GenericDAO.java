package operator.dao.api;

import operator.exceptions.CustomDAOException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public interface GenericDAO<E, K> {

    public void create(E entity) throws CustomDAOException;

    public E read(K id) throws CustomDAOException;

    public void update(E entity) throws CustomDAOException;

    public void delete(E entity) throws CustomDAOException;

    public List<E> getAll() throws CustomDAOException;

}