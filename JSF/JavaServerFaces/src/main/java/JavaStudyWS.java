import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

/**
 * Created by Artyom Karnov on 10/5/16.
 * artyom-karnov@yandex.ru
 **/
public class JavaStudyWS {
    public static void main(String[] args) throws IOException {
//        String output = null;
//        String URLstring = "http://localhost:8080/getRestInfo";
//        URL url = new URL(URLstring);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                (conn.getInputStream())));
//
//        output = br.readLine();
//        conn.disconnect();
//        System.out.println(output);


        String restServiceUrl = "http://localhost:8080/getRestInfo?contract=new";

        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(restServiceUrl);

        Header mtHeader = new Header();
        mtHeader.setName("content-type");
        mtHeader.setValue("application/x-www-form-urlencoded");
        getMethod.addRequestHeader(mtHeader);

        mtHeader = new Header();
        mtHeader.setName("accept");
        mtHeader.setValue("application/xml");
        getMethod.addRequestHeader(mtHeader);

        httpClient.executeMethod(getMethod);
        String output = getMethod.getResponseBodyAsString();

        System.out.println(output);
    }
}
