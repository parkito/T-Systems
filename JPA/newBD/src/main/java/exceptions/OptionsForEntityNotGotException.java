package exceptions;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
/**
 * exception for situation when option for entity  couldn't be found
 */
public class OptionsForEntityNotGotException extends CustomDAOException {
    public OptionsForEntityNotGotException(String message) {
        super(message);
    }

    public OptionsForEntityNotGotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
