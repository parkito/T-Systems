package manipulating;

import base.Contract;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class ClientStatusDAO {
    public boolean isAdministrator(){
        String query = "SELECT * FROM ClientStatus WHERE status='" + "admin"+ "'";
        Contract contract = new Contract();
        Object object = MainDAO.getExistingEntity(contract, query);
        return true;
    }
}
