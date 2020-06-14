package com.ferry.covidhelper.websocket;

import java.util.Set;

public interface SessionRegistry {

    boolean isUserActive(String userId);

    Set<String> connectedUsers();
}
