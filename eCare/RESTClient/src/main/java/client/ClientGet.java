package client;

import org.apache.commons.codec.binary.Base64;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Stateless
public class ClientGet {

    public String getContract(String tariffTitle) {
        String result = null;
        try {
            String URL = "http://localhost:8080/getRestInfo?contract=" + tariffTitle;
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Basic " +
                    new String(new Base64().encodeBase64("b@b.ru:12345".getBytes())));
            if (conn.getResponseCode() != 200) {
                return "error";
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            result = br.readLine();
            conn.disconnect();

        } catch (MalformedURLException e) {
            return "error";

        } catch (IOException e) {
            return "error";
        }
        return result;
    }
}
