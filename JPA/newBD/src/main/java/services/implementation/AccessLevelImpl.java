package services.implementation;


import dao.api.AccessLevelDAO;
import dao.implementation.AccessLevelDAOImpl;
import entities.AccessLevel;
import exceptions.CustomDAOException;
import services.api.AccessLevelService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

public class AccessLevelImpl implements AccessLevelService {
    private AccessLevelDAO accessLevelDAO = new AccessLevelDAOImpl();


    /**
     *creating accessLevel entity in base
     * @param accessLevel
     * @throws CustomDAOException
     */
    @Override
    public void createEntity(AccessLevel accessLevel) throws CustomDAOException {
        accessLevelDAO.create(accessLevel);
    }

    /**
     *getting accessLevel entity by id
     * @param id
     * @return
     * @throws CustomDAOException
     */

    @Override
    public AccessLevel getEntityById(Integer id) throws CustomDAOException {
        return accessLevelDAO.read(id);
    }

    /**
     *updateing accessLevel entity in base
     * @param accessLevel
     * @throws CustomDAOException
     */
    @Override
    public void updateEntity(AccessLevel accessLevel) throws CustomDAOException {
        accessLevelDAO.update(accessLevel);
    }

    /**
     *deleting accessLevel entity from base
     * @param accessLevel
     * @throws CustomDAOException
     */
    @Override
    public void deleteEntity(AccessLevel accessLevel) throws CustomDAOException {
        accessLevelDAO.delete(accessLevel);

    }

    /**
     *
     * @return
     * @throws CustomDAOException
     */
    @Override
    public List<AccessLevel> getAll() throws CustomDAOException {
        return accessLevelDAO.getAll();
    }


}


