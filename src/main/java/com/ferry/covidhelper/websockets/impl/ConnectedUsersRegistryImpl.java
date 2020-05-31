package com.ferry.covidhelper.websockets.impl;

import com.ferry.covidhelper.websockets.ConnectedUsersRegistry;
import org.springframework.web.socket.messaging.DefaultSimpUserRegistry;

import static java.util.Objects.isNull;

public class ConnectedUsersRegistryImpl extends DefaultSimpUserRegistry implements ConnectedUsersRegistry {

    @Override
    public boolean isConnected(String userId) {
        return !isNull(getUser(userId));
    }
}
