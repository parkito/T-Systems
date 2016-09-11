package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * exception for situation when operation with entities couldn't be executed
 */
public class CustomDAOException extends RuntimeException {
    public CustomDAOException(String message) {
        super(message);
    }

    public CustomDAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
