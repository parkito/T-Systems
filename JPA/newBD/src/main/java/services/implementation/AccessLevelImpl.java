package services.implementation;


import dao.api.AccessLevelDAO;
import entities.AccessLevel;
import exceptions.CustomDAOException;
import services.api.AccessLevelService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/

public class AccessLevelImpl implements AccessLevelService {
    private AccessLevelDAO accessLevelDAO;

    @Override

    public void createEntity(AccessLevel accessLevel) throws CustomDAOException {
        this.accessLevelDAO.create(accessLevel);
    }

    @Override
    public AccessLevel getEntityById(Integer id) throws CustomDAOException {
        return this.accessLevelDAO.read(id);
    }

    @Override
    public void updateEntity(AccessLevel accessLevel) throws CustomDAOException {
        this.accessLevelDAO.update(accessLevel);
    }

    @Override
    public void deleteEntity(AccessLevel accessLevel) throws CustomDAOException {
        this.accessLevelDAO.delete(accessLevel);

    }

    @Override
    public List<AccessLevel> getAll() throws CustomDAOException {
        return this.accessLevelDAO.getAll();
    }
}


