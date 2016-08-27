package services.implementation;


import dao.api.UserDAO;
import dao.implementation.UserDAOImpl;
import entities.User;
import exceptions.CustomDAOException;
import exceptions.UserNotFoundException;
import services.api.UserService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void createEntity(User user) throws CustomDAOException {
        userDAO.create(user);
    }

    @Override
    public User getEntityById(Integer id) throws CustomDAOException {
        return userDAO.read(id);
    }

    @Override
    public void updateEntity(User entity) throws CustomDAOException {
        userDAO.update(entity);
    }

    @Override
    public void deleteEntity(User entity) throws CustomDAOException {
        userDAO.delete(entity);
    }


    @Override
    public List<User> getAll() throws CustomDAOException {
        return userDAO.getAll();

    }

    @Override
    public boolean isEntityExists(User entity) throws CustomDAOException {
        return userDAO.isEntityExists(entity);
    }


    @Override
    public User getUserByNumber(String number) throws UserNotFoundException {
        return userDAO.getUserByNumber(number);
    }


    @Override
    public User getUserByEMAil(String eMail) throws UserNotFoundException {
        return userDAO.getUserByEMAil(eMail);
    }


}
