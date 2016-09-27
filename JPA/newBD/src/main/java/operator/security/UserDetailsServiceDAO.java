package operator.security;

/**
 * Created by Artyom Karnov on 9/25/16.
 * artyom-karnov@yandex.ru
 **/

import operator.dao.api.UserDAO;
import operator.entities.User;
import operator.exceptions.CustomDAOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring security class for authorization aspect.
 */
@Service("userDetailsService")
public class UserDetailsServiceDAO implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    /**
     *
     * @param eMail - user Email
     * @return
     * @throws UsernameNotFoundException when eMail isn't correct
     */
    @Override
    public UserDetails loadUserByUsername(final String EMail) throws UsernameNotFoundException {
        User user;
        try {
            user = userDAO.getUserByEMAil(EMail);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getAccessLevel().getStatus()));
            return new org.springframework.security.core.userdetails.User(EMail, user.getPassword(), true, true, true, true, authorities);
        }
        catch (CustomDAOException ex) {
            throw new UsernameNotFoundException(EMail + " not found");
        }
        catch (Exception ex) {
            return null;
        }

    }
}

