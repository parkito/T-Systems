package client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
@ManagedBean(name = "beanController")
@SessionScoped
public class BeanController {

    @EJB(beanName = RestClientImpl.JNDI)
    private RestClient restClient;

    private String tariff;

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getInfo() throws IOException {
        if (restClient.buildPDF(tariff)) {
            return "home";
        } else return "error";
    }

    public void home() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("http://localhost:8080/");
    }

    public void back() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("http://localhost:8080/RESTClient/");
    }


}
