package com.ferry.covidhelper.configurations;

import com.ferry.covidhelper.security.user.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

@Component
public class UserHandshakeHandler extends DefaultHandshakeHandler {

    private final static String USER_ID_PARAMETER_KEY = "userId";

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        return (Principal) authenticationFacade.getAuthentication().getPrincipal();
    }

}
