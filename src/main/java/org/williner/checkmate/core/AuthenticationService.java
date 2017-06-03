package org.williner.checkmate.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.williner.checkmate.crud.user.UserDO;
import org.williner.checkmate.crud.user.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO user = userRepository.findByNickname(username);

        if (user != null) {
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "USER";
                }
            });

            return new User(user.getNickname(), "pass", grantedAuthorities);
        } else {
            return null;
        }
    }
}
