package services.implementation;


import dao.api.UserDAO;
import dao.implementation.UserDAOImpl;
import entities.AccessLevel;
import entities.User;
import exceptions.CustomDAOException;
import exceptions.UserNotFoundException;
import services.api.UserService;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
// TODO: 8/31/16 work with blocking
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    /**
     * creating contract user in base
     * @param user
     * @throws CustomDAOException
     */
    @Override
    public void createEntity(User user) throws CustomDAOException {
        if (!isUserExists(user)) {
            userDAO.create(user);
        } else System.out.println("User already exists");
    }

    /**
     * get user entity by id
     * @param id
     * @return
     * @throws CustomDAOException
     */
    @Override
    public User getEntityById(Integer id) throws CustomDAOException {
        return userDAO.read(id);
    }

    /**
     * update user entity in base
     * @param entity
     * @throws CustomDAOException
     */
    @Override
    public void updateEntity(User entity) throws CustomDAOException {
        userDAO.update(entity);
    }

    /**
     * delete user entity from base
     * @param entity
     * @throws CustomDAOException
     */
    @Override
    public void deleteEntity(User entity) throws CustomDAOException {
        userDAO.delete(entity);
    }

    /**
     * getting all user entities from base
     * @return
     * @throws CustomDAOException
     */
    @Override
    public List<User> getAll() throws CustomDAOException {
        return userDAO.getAll();

    }

    /**
     * getting user entity by number
     * @param number
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public User getUserByNumber(String number) throws UserNotFoundException {
        return userDAO.getUserByNumber(number);
    }

    /**
     * getting user entity by email
     * @param eMail
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public User getUserByEMAil(String eMail) throws UserNotFoundException {
        return userDAO.getUserByEMAil(eMail);
    }

    /**
     * checking user existing in base
     * @param user
     * @return
     */
    public boolean isUserExists(User user) {
        try {
            return getUserByEMAil(user.getEmail()) != null ? true : false;
        } catch (UserNotFoundException ex) {
            return false;
        }
    }

    /**
     * changing user's access level in base
     * @param user
     * @param accessLevel
     */
    public void cahngeUserAccessLevel(User user, AccessLevel accessLevel) {
        user.setAccessLevel(accessLevel);
        updateEntity(user);
    }

}
