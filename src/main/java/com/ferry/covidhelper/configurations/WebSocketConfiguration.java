package com.ferry.covidhelper.configurations;

import com.ferry.covidhelper.websockets.ConnectedUsersRegistry;
import com.ferry.covidhelper.websockets.impl.ConnectedUsersRegistryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    public final static String USER_TOPIC = "/users/";
    public final static String CHAT_TOPIC = "/chats/";

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websockets/connect");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/chats");
        registry.enableSimpleBroker("/users");
    }

    @Bean
    public ConnectedUsersRegistry connectedUsersRegistry() {
        return new ConnectedUsersRegistryImpl();
    }
}

