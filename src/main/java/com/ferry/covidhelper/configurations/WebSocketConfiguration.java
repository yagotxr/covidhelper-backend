package com.ferry.covidhelper.configurations;

import com.ferry.covidhelper.security.user.AuthenticationFacade;
import com.ferry.covidhelper.security.user.AuthenticationImpl;
import com.ferry.covidhelper.websocket.SessionRegistry;
import com.ferry.covidhelper.websocket.custom.CustomSessionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/connect")
                .setHandshakeHandler(new UserHandshakeHandler())
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/chat",
                "/connectedUsers");
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new CustomSessionRegistry();
    }

    @Bean
    public AuthenticationFacade authenticationFacade(){
        return new AuthenticationImpl();
    }
}
