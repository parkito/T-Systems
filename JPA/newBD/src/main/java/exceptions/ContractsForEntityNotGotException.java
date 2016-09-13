package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Exception for situation when contract for user couldn't be available
 */
public class ContractsForEntityNotGotException extends CustomDAOException {
    /**
     * Exception with message for situation when user's contract couldn't be available
     *
     * @param message message for exception
     */
    public ContractsForEntityNotGotException(String message) {
        super(message);
    }

    /**
     * Exception with message and throwable for situation when user's contract couldn't be available
     *
     * @param message   for exception
     * @param throwable object for exception
     */
    public ContractsForEntityNotGotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
