package com.ferry.covidhelper.configurations;

import com.ferry.covidhelper.security.user.AuthenticationFacade;
import com.ferry.covidhelper.security.user.AuthenticationImpl;
import com.ferry.covidhelper.websocket.StompPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class UserHandshakeHandler extends DefaultHandshakeHandler {

    private final static String USER_ID_PARAMETER_KEY = "userId";

    private AuthenticationFacade authenticationFacade = new AuthenticationImpl();

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        Principal principal = (Principal) authenticationFacade.getAuthentication().getPrincipal();
        if(isNull(principal)){
                return new StompPrincipal(UUID.randomUUID().toString());
        }

        return principal;
    }
}
