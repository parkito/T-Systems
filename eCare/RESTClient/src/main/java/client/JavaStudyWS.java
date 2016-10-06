import client.ClientGet;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 10/5/16.
 * artyom-karnov@yandex.ru
 **/
public class JavaStudyWS {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientGet clientGet = new ClientGet();
        Document document = new Document();
        try {
            File file = new File("/tmp/contracts.pdf");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            document.add(new Paragraph("A Hello World PDF document."));
            document.add(new Paragraph(clientGet.getContract("base")));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
