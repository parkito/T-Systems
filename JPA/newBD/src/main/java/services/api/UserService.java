package services.api;

import entities.User;
import exceptions.UserNotFoundException;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public interface UserService extends GenericService<User, Integer> {

    public User getUserByNumber(String number) throws UserNotFoundException;

    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}
