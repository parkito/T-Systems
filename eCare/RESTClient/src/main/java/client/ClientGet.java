package client;

import org.apache.commons.codec.binary.Base64;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@ManagedBean
@SessionScoped
public class ClientGet {

    public String getContract(String tariffTitle) throws IOException {

        String output = null;
        String URL = "http://localhost:8080/getRestInfo?contract=base";
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " +
                new String(new Base64().encodeBase64("b@b.ru:12345".getBytes())));
        if (conn.getResponseCode() != 200) {
            System.out.println("Failed : HTTP error code : "
                    + conn.getResponseCode());
            System.exit(1);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        output = br.readLine();
        conn.disconnect();
        return output;


    }
}
