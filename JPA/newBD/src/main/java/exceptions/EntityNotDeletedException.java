package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
/**
 * exception for situation when entities couldn't be deleted
 */
public class EntityNotDeletedException extends CustomDAOException {
    /**
     * exception with message for situation when entity couldn't be deleted
     * @param message
     */
    public EntityNotDeletedException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when entity couldn't be deleted
     * @param message
     * @param throwable
     */
    public EntityNotDeletedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
