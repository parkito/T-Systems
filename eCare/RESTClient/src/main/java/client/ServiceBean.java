package client;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Artyom Karnov on 5/10/16.
 * artyom-karnov@yandex.ru
 **/
@ManagedBean(name = "serviceBean")
@SessionScoped
public class ServiceBean {

    @EJB(beanName = RestClientImpl.JNDI_NAME)
    RestClient restClient;

    public String request;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String askService() {
        String string = restClient.getService("base");
        request = string;
        return "welcome";
    }


    public void downloadFile() throws IOException {
        HttpServletResponse response = (HttpServletResponse)
                FacesContext.getCurrentInstance().getExternalContext().getResponse();
        try {
            // Get the text that will be added to the PDF
            String text = request;
            if (text == null || text.trim().length() == 0) {
                text = "You didn't enter any text.";
            }
            // step 1
            Document document = new Document();
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph(
                    "You have submitted the following text using the %s method:"));
            document.add(new Paragraph(text));
            // step 5
            document.close();

            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                    "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
            FacesContext.getCurrentInstance().getResponseComplete();
        } catch (DocumentException e) {
            throw new IOException(e.getMessage());
        }

    }
}
