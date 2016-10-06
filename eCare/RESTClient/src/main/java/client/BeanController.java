package client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import org.apache.commons.codec.binary.Base64;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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


    public List<UserDTO> getContract(String tariffTitle) throws IOException {
        String result = null;
        String URL = "http://localhost:8080/getRestInfo?contract=" + tariffTitle;
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
        result = br.readLine();
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<UserDTO>>() {
        }.getType();
        List<UserDTO> users = gson.fromJson(result, userListType);
        conn.disconnect();
        return users;
    }

    public void buildPDF() throws IOException {
        Document document = new Document();
        try {
            File file = new File("/tmp/Report(" + new Date() + ").pdf");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            document.add(new Paragraph(new Date() + ". Report for BASE tariff. \n\n"));
            document.add(new DottedLineSeparator());
            document.add(new Paragraph());
            for (UserDTO userDTO : getContract("base")) {
                document.add(new Paragraph(String.format("|%-20s| %-20s| %-20s| %-30s| %-20s|\n\n", userDTO.getUserId(),
                        userDTO.getName(), userDTO.getSecondName(), userDTO.getEmail(), userDTO.getContracts())));
            }
            document.add(new DottedLineSeparator());
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
