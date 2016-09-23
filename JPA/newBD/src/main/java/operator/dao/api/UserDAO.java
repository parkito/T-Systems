package operator.dao.api;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public interface UserDAO extends GenericDAO<User, Integer> {

    public User getUserByNumber(String number) throws UserNotFoundException;


    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}
