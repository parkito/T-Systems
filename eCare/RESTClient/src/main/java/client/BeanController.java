package client;

import org.apache.commons.codec.binary.Base64;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
@ManagedBean
@SessionScoped
public class BeanController implements Serializable {

    private static final long serialVersionUID = 2L;

    private String tariff;

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String status) {
        this.tariff = status;
    }

    public String getInfo() {
        if ("error".equals(getContract(tariff)) || getContract(tariff) == null)
            return "User";
        else {
            result = getContract(tariff);
            return "home";
        }
    }

    public String getContract(String tariffTitle) {
        String result = null;
        try {
            String URL = "http://localhost:8080/getRestInfo?contract=" + tariffTitle;
            java.net.URL url = new URL(URL);
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
