package org.williner.checkmate.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.williner.checkmate.crud.user.UserDO;

import javax.servlet.http.HttpServletResponse;

@RestController
public class SessionController {
    @Autowired
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping(path = "/api/session")
    public UserDO getSession(HttpServletResponse httpResponse) {
        UserDO user = sessionService.getSessionUser();

        if (user != null) {
            return user;
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
    }
}
