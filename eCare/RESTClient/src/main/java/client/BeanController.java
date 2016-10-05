package client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
@ManagedBean
@SessionScoped
public class BeanController {

    @EJB
    private ClientGet clientGet;

    public String status;

    @GET
    @Path("/getInfo")
    public void getInfo(@QueryParam("contract") String tariffTitle) {
        if ("error".equals(clientGet.getContract(tariffTitle))) {
            status = clientGet.getContract(tariffTitle);
        } else {
            status = "success";
        }
    }

    public String get() {
        return "stirng";
    }

}
