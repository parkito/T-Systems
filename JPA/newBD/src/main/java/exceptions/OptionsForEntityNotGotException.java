package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class OptionsForEntityNotGotException extends CustomDAOException {
    public OptionsForEntityNotGotException(String message) {
        super(message);
    }

    public OptionsForEntityNotGotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
