package com.ferry.covidhelper.websocket.custom;

import com.ferry.covidhelper.services.UserService;
import com.ferry.covidhelper.websocket.SessionRegistry;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.DefaultSimpUserRegistry;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
@AllArgsConstructor
public class CustomSessionRegistry extends DefaultSimpUserRegistry implements SessionRegistry {

    private final UserService userService;

    @Override
    public boolean isUserActive(String userId) {
        return !isNull(getUser(userId));
    }

    @Override
    public Set<String> connectedUsers() {
        return getUsers().stream().map(SimpUser::getName)
                .collect(Collectors.toSet());
    }
}
