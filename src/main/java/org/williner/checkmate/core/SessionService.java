package org.williner.checkmate.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.williner.checkmate.crud.user.UserDO;

import javax.servlet.http.HttpServletResponse;

@Service
public class SessionService {
    public UserDO getSessionUser() {
        UserDO user = null;

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails)principal;
                user = new UserDO();
                user.setNickname(userDetails.getUsername());
            }
        }

        return user;
    }
}
