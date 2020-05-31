package com.ferry.covidhelper.websockets;

import org.springframework.messaging.simp.user.SimpUserRegistry;

public interface ConnectedUsersRegistry extends SimpUserRegistry {

    boolean isConnected(String userId);
}
