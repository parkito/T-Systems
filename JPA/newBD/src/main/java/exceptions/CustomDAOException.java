package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * exception for situation when operation with entities couldn't be executed
 */
public class CustomDAOException extends RuntimeException {
    /**
     * exception with message for situation when something goes wrong on DAO
     * @param message
     */
    public CustomDAOException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when something goes wrong on DAO
     * @param message
     * @param throwable
     */
    public CustomDAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
