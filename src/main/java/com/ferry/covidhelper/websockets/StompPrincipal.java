package com.ferry.covidhelper.websockets;

import lombok.AllArgsConstructor;

import java.security.Principal;

@AllArgsConstructor
public class StompPrincipal implements Principal {

    private final String id;

    @Override
    public String getName() {
        return null;
    }
}
