package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * exception for situation when contract for user couldn't be available
 */
public class ContractsForEntityNotGotException extends CustomDAOException {
    /**
     * exception with message for situation when user's contract couldn't be available
     * @param message
     */
    public ContractsForEntityNotGotException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when user's contract couldn't be available
     * @param message
     * @param throwable
     */
    public ContractsForEntityNotGotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
