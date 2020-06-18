package com.ferry.covidhelper.websocket;

import lombok.AllArgsConstructor;

import java.security.Principal;

@AllArgsConstructor
public class StompPrincipal implements Principal {

    private final String userId;

    @Override
    public String getName() {
        return userId;
    }
}
