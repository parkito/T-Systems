package client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
@ManagedBean
@SessionScoped
public class BeanController implements Serializable {

    @EJB(beanName = RestClientImpl.JNDI)
    RestClient restClient;

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


}
