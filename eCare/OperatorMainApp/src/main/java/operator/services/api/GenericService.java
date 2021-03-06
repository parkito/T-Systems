package operator.services.api;


import operator.exceptions.CustomDAOException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Interface for GenericService
 */
public interface GenericService<E, K> {
    public void createEntity(E entity) throws CustomDAOException;

    public E getEntityById(K id) throws CustomDAOException;

    public void updateEntity(E entity) throws CustomDAOException;

    public void deleteEntity(E entity) throws CustomDAOException;

    public List<E> getAll() throws CustomDAOException;


}
