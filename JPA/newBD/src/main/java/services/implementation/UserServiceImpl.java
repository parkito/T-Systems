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
        if (!isUserExists(user))
            userDAO.create(user);
        else System.out.println("User already exists");
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
    public User getUserByNumber(String number) throws UserNotFoundException {
        return userDAO.getUserByNumber(number);
    }


    @Override
    public User getUserByEMAil(String eMail) throws UserNotFoundException {
        return userDAO.getUserByEMAil(eMail);
    }

    public boolean isUserExists(User user) {
        try {
            return getUserByEMAil(user.getEmail()) != null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

}
