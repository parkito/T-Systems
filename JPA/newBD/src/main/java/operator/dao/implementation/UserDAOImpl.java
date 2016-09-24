package operator.dao.implementation;

import operator.dao.api.UserDAO;
import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Access to user functionality
 */
@Repository("userDAO")
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Getting user entity by number
     * @param number entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    @Override
    public User getUserByNumber(String number) throws UserNotFoundException {
        try {
            Query query = entityManager.createQuery("select c.user from Contract c where c.number=:number")
                    .setParameter("number", number);
            return (User) query.getSingleResult();
        } catch (PersistenceException e) {
            throw new UserNotFoundException("User " + number + " wasn't found", e);
        }

    }

    /**
     * Getting user entity by email
     * @param eMail entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    @Override
    public User getUserByEMAil(String eMail) throws UserNotFoundException {
        try {
            Query query = entityManager.createQuery("select u from User u where u.email=:eMail")
                    .setParameter("eMail", eMail);
            return (User) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("User with email " + eMail + " not found!", ex);
        }

    }


}
