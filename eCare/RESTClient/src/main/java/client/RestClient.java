package client;

import java.io.IOException;
import java.util.List;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
public interface RestClient {
    public List<UserDTO> getContracts(String tariffTitle) throws IOException;

    public boolean buildPDF(String tariffTitle) throws IOException;
}
