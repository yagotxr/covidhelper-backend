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

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websockets/connect");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/doctors/chats");
    }

    @Bean
    public ConnectedUsersRegistry connectedUsersRegistry() {
        return new ConnectedUsersRegistryImpl();
    }
}

