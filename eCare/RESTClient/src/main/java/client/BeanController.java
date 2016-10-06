package client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.io.Serializable;

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
}
