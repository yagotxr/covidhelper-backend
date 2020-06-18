package com.ferry.covidhelper.websocket;

import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.responses.DoctorResponse;
import com.ferry.covidhelper.services.DoctorService;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.slf4j.LoggerFactory.getLogger;

@Component
@AllArgsConstructor
public class WebSocketEventHandler {

    private final Logger logger = getLogger(WebSocketEventHandler.class);
    private final SessionRegistry sessionRegistry;
    private final DoctorService doctorService;
    private final UserService userService;
    private final SimpMessageSendingOperations sendingOperations;

    @EventListener(SessionConnectedEvent.class)
    public void getOnlineDoctors(SessionConnectedEvent event) {
        Set<String> connectedUsers = sessionRegistry.connectedUsers();
        Set<Doctor> onlineDoctors = connectedUsers.stream().map(doctorService::getDoctorById).collect(toSet());
        Set<DoctorResponse> doctorResponses = onlineDoctors.stream()
                .map(onlineDoctor -> {
                    User user = userService.findUser(onlineDoctor.getUser());
                    return DoctorResponse.of(onlineDoctor, user);
                }).collect(toSet());
        doctorResponses.remove(null);
        sendingOperations.convertAndSend("/connectedUsers", doctorResponses);
    }

    @EventListener(SessionSubscribeEvent.class)
    public void subscriptionListener(SessionSubscribeEvent event) {
        logger.info("User subscribed.");
    }

    @EventListener(SessionDisconnectEvent.class)
    public void disconnectionListener(SessionDisconnectEvent event) {
        logger.info("User disconnected.");
    }

}
