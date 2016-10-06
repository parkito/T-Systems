import client.ClientGet;
import client.UserDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Artyom Karnov on 10/5/16.
 * artyom-karnov@yandex.ru
 **/
public class JavaStudyWS {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientGet clientGet = new ClientGet();
        Document document = new Document();
        try {
            File file = new File("/tmp/Report(" + new Date() + ").pdf");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            document.add(new Paragraph(new Date() + ". Report for BASE tariff. \n\n"));
            document.add(new DottedLineSeparator());
            document.add(new Paragraph());
            for (UserDTO userDTO : clientGet.getContract("base")) {
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
