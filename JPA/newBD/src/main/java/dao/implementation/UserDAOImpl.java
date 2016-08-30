package dao.implementation;

import dao.api.UserDAO;
import entities.User;
import exceptions.UserNotFoundException;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {
    //    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("operator");
//    private EntityManager entityManager = emf.createEntityManager();
//    @PersistenceContext
//    private EntityManager entityManager = emf.createEntityManager();

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
