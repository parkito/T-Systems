package client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.QueryParam;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
@ManagedBean
@SessionScoped
public class BeanController implements Serializable {

    private static final long serialVersionUID = 1L;
//    @EJB
//    private ClientGet clientGet;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get() {
        return "STRING";
    }

}
