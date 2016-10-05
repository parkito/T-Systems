import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Artyom Karnov on 10/5/16.
 * artyom-karnov@yandex.ru
 **/
public class JavaStudyWS {
    public static void main(String[] args) throws IOException {
        String output = null;
        String URLstring = "http://localhost:8080/getRestInfo?contract=right";
        URL url = new URL(URLstring);
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
        System.out.println(output);


//        String restServiceUrl = "http://localhost:8080/getRestInfo?contract=new";
//
//        HttpClient httpClient = new HttpClient();
//        GetMethod getMethod = new GetMethod(restServiceUrl);
//
//        Header mtHeader = new Header();
//        mtHeader.setName("content-type");
//        mtHeader.setValue("application/x-www-form-urlencoded");
//        getMethod.addRequestHeader(mtHeader);
//
//        mtHeader = new Header();
//        mtHeader.setName("accept");
//        mtHeader.setValue("application/xml");
//        getMethod.addRequestHeader(mtHeader);
//
//        httpClient.executeMethod(getMethod);
//        String output = getMethod.getResponseBodyAsString();
//
//        System.out.println(output);
    }
}
