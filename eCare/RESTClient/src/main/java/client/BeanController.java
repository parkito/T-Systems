package client;

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

    private static final long serialVersionUID = 2L;

    private String tariff;

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String status) {
        this.tariff = status;
    }

    public String getInfo() {
        if (tariff.equals("my"))
            return "User";
        else return "home";
    }

}
