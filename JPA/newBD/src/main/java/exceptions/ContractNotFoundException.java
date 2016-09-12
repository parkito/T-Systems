package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * exception for situation when contract couldn't be available
 */
public class ContractNotFoundException extends CustomDAOException {
    /**
     * Exeption with message for situation when contract couldn't be available
     * @param message
     */
    public ContractNotFoundException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when contract couldn't be available
     * @param message
     * @param throwable
     */
    public ContractNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
