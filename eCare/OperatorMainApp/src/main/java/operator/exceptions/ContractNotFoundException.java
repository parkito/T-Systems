package operator.exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Exception for situation when contract couldn't be available
 */
public class ContractNotFoundException extends CustomDAOException {
    /**
     * Exception with message for situation when contract couldn't be available
     *
     * @param message message for exception
     */
    public ContractNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with message and throwable for situation when contract couldn't be available
     *
     * @param message   message for exception
     * @param throwable object for message
     */
    public ContractNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
