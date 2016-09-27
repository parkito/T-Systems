package operator.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Artyom Karnov on 9/28/16.
 * artyom-karnov@yandex.ru
 **/
public class ManagerStatus implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "Manager";
    }
}
