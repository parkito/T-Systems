package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
/**
 * exception for situation when entities couldn't be deleted
 */
public class EntityNotDeletedException extends CustomDAOException {
    public EntityNotDeletedException(String message) {
        super(message);
    }

    public EntityNotDeletedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
