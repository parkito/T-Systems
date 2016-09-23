package operator.exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Exception for situation when entities couldn't be deleted
 */
public class EntityNotDeletedException extends CustomDAOException {
    /**
     * Exception with message for situation when entity couldn't be deleted
     *
     * @param message message for exception
     */
    public EntityNotDeletedException(String message) {
        super(message);
    }

    /**
     * Exception with message and throwable for situation when entity couldn't be deleted
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public EntityNotDeletedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
