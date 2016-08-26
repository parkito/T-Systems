package services.implementation;


import dao.api.UserDAO;
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
    private UserDAO userDAO;

    @Override
    public void createEntity(User entity) throws CustomDAOException {
        this.userDAO.create(entity);
    }

    @Override
    public User getEntityById(Integer id) throws CustomDAOException {
        return this.userDAO.read(id);
    }

    @Override
    public void updateEntity(User entity) throws CustomDAOException {
        this.userDAO.update(entity);
    }

    @Override
    public void deleteEntity(User entity) throws CustomDAOException {
        this.userDAO.delete(entity);
    }


    @Override
    public List<User> getAll() throws CustomDAOException {
        return this.userDAO.getAll();

    }


    @Override
    public User getUserByNumber(String number) throws UserNotFoundException {
        return this.userDAO.getUserByNumber(number);
    }


    @Override
    public User getUserByLogin(String login) throws UserNotFoundException {
        return this.userDAO.getUserByEMAil(login);
    }


}
