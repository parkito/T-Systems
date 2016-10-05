
package client;

import org.apache.commons.codec.binary.Base64;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Artyom Karnov on 5/10/16.
 * artyom-karnov@yandex.ru
 **/
@Stateless(name = RestClientImpl.JNDI_NAME)
public class RestClientImpl implements RestClient {
    
    public static final String JNDI_NAME = "restClientBean";

    public String getService(String tariffTitle) {
        String result = null;
        try {
            String URL = "http://localhost:8080/restGetRestInfo?contract=" + tariffTitle;
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Basic " +
                    new String(new Base64().encodeBase64("b@b:12345".getBytes())));
            if (conn.getResponseCode() != 200) {
                return "Failed : HTTP error code : "
                        + conn.getResponseCode();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            result = br.readLine();
            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return result;
    }
    
}
