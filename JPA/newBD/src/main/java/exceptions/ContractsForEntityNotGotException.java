package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class ContractsForEntityNotGotException extends CustomDAOException {
    public ContractsForEntityNotGotException(String message) {
        super(message);
    }

    public ContractsForEntityNotGotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
