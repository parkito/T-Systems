package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
/**
 * exception for situation when user couldn't be available
 */
public class UserNotFoundException extends CustomDAOException {
    /**
     * exception with message for situation when user wasn't found
     * @param message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when user wasn't found
     * @param message
     * @param throwable
     */
    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
