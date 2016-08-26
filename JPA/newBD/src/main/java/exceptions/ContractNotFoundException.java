package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class ContractNotFoundException extends CustomDAOException {
    public ContractNotFoundException(String message) {
        super(message);
    }

    public ContractNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
