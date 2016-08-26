package dao.api;

import entities.User;
import exceptions.UserNotFoundException;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public interface UserDAO extends GenericDAO<User, Integer> {

    public User getUserByNumber(String number) throws UserNotFoundException;


    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}
