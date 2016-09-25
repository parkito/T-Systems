package operator.exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Exception for situation when user couldn't be available
 */
public class UserNotFoundException extends CustomDAOException {
    /**
     * Exception with message for situation when user wasn't found
     *
     * @param message message for exception
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when user wasn't found
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
