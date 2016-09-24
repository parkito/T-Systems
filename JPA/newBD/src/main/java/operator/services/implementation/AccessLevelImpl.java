package operator.services.implementation;


import operator.dao.api.AccessLevelDAO;
import operator.dao.implementation.AccessLevelDAOImpl;
import operator.entities.AccessLevel;
import operator.exceptions.CustomDAOException;
import operator.services.api.AccessLevelService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Access level operations
 */
public class AccessLevelImpl implements AccessLevelService {
    private AccessLevelDAO accessLevelDAO = new AccessLevelDAOImpl();

    /**
     * Creating accessLevel entity in base
     * @param accessLevel entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void createEntity(AccessLevel accessLevel) throws CustomDAOException {
        accessLevelDAO.create(accessLevel);
    }

    /**
     * Getting accessLevel entity by id
     * @param id id for getting
     * @return level with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */

    @Override
    @Transactional
    public AccessLevel getEntityById(Integer id) throws CustomDAOException {
        return accessLevelDAO.read(id);
    }

    /**
     * Updating accessLevel entity in base
     * @param accessLevel entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(AccessLevel accessLevel) throws CustomDAOException {
        accessLevelDAO.update(accessLevel);
    }

    /**
     * Deleting accessLevel entity from base
     * @param accessLevel entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(AccessLevel accessLevel) throws CustomDAOException {
        accessLevelDAO.delete(accessLevel);

    }

    /**
     * Getting list of access levels entities
     * @return list of all levels
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public List<AccessLevel> getAll() throws CustomDAOException {
        return accessLevelDAO.getAll();
    }

}


