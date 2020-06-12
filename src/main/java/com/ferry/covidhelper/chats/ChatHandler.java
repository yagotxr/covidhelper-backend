package com.ferry.covidhelper.chats;

import com.ferry.covidhelper.payloads.requests.ChatRequest;
import com.ferry.covidhelper.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import static com.ferry.covidhelper.chats.Chat.newChat;
import static com.ferry.covidhelper.configurations.WebSocketConfiguration.USER_TOPIC;

@Component
@AllArgsConstructor
public class ChatHandler {

    private final DoctorService doctorService;
    private final SimpMessageSendingOperations sendingOperations;

    public void handleAnonymousChatRequest(ChatRequest request) {
        doctorService.getDoctor(request.getDoctorId());
        Chat chat = newChat(request);

        String userDestination = USER_TOPIC + request.getRequesterId();
        String doctorDestination = USER_TOPIC + request.getDoctorId();
        sendingOperations.convertAndSend(userDestination, chat);
        sendingOperations.convertAndSend(doctorDestination, chat);
    }
}
