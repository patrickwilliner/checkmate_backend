package org.williner.checkmate.core;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) {
        response.setContentType("application/json;charset=UTF-8");
        //PrintWriter writer = response.getWriter();
        //writer.write(mapper.writeValueAsString(object));
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //writer.flush();
        //writer.close();

        exception.printStackTrace();
    }
}
