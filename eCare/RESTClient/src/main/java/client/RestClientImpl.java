package client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import org.apache.commons.codec.binary.Base64;

import javax.ejb.Stateless;
import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
@Stateless(name = RestClientImpl.JNDI)
public class RestClientImpl implements RestClient {
    public static final String JNDI = "RestClient";

    @Override
    public List<UserDTO> getContracts(String tariffTitle) throws IOException {
        String result = null;
        String URL = "http://localhost:8080/getRestInfo?contract=" + tariffTitle;
        java.net.URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " +
                new String(new Base64().encodeBase64("b@b.ru:12345".getBytes())));
        if (conn.getResponseCode() != 200) {
            System.out.println("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        result = br.readLine();
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<UserDTO>>() {
        }.getType();
        List<UserDTO> users = gson.fromJson(result, userListType);
        conn.disconnect();
        return users;
    }

    @Override
    public boolean buildPDF(String tariffTitle) throws IOException {
        Document document = new Document();
        try {
            File file = new File("/tmp/Report.pdf");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            document.add(new Paragraph(new Date() + ". Report for BASE tariff. \n\n"));
            document.add(new DottedLineSeparator());
            document.add(new Paragraph());
            List<UserDTO> users = getContracts(tariffTitle);
            for (UserDTO userDTO : users) {
                document.add(new Paragraph(String.format("|%-20s| %-20s| %-20s| %-30s| %-20s|\n\n", userDTO.getUserId(),
                        userDTO.getName(), userDTO.getSecondName(), userDTO.getEmail(), userDTO.getContracts())));
            }
            document.add(new DottedLineSeparator());
            document.close();
            writer.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}
