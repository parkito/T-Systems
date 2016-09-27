package operator.security;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Artyom Karnov on 9/28/16.
 * artyom-karnov@yandex.ru
 **/
@Service("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String eMail = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userService.getUserByEMAil(eMail);

        if (user == null) {
            throw new UserNotFoundException(eMail + " not found");
        }

        if (!password.equals(user.getPassword())) {
            throw new UserNotFoundException("Wrong password.");
        }

        UserStatus userStatus = new UserStatus();
        ManagerStatus managerStatus = new ManagerStatus();
        List<GrantedAuthority> authorityList = new ArrayList<>();
        if (user.getAccessLevel().getAccessLevelId() == 1)
            authorityList.add(userStatus);
        else authorityList.add(managerStatus);
        String auth = user.getAccessLevel().getStatus();
        Collection<? extends GrantedAuthority> authorities = authorityList;
        return new UsernamePasswordAuthenticationToken(user, password, authorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
