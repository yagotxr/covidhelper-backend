package com.ferry.covidhelper.configurations;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import java.security.Principal;

public class CustomChannelInterceptor implements ChannelInterceptor {

    private static final String SIMP_USER_HEADER_KEY = "simp_user";

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
        sha.setUser((Principal) message.getHeaders().get(SIMP_USER_HEADER_KEY));
        return message;
    }

}
