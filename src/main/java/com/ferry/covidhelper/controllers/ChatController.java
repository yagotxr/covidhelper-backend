package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.chats.ChatHandler;
import com.ferry.covidhelper.chats.Message;
import com.ferry.covidhelper.payloads.requests.ChatRequest;
import com.ferry.covidhelper.payloads.requests.MessageRequest;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations sendingOperations;
    private final UserService userService;
    private final ChatHandler chatHandler;

    @MessageMapping("/send/{chatId}")
    public Message sendMessage(@DestinationVariable String chatId,
                               MessageRequest messageRequest) {


        Message message = Message.build(messageRequest, user);
        sendingOperations.convertAndSend();
    }

    @GetMapping("/chats/anonymous")
    @ResponseStatus(OK)
    public String requestAnonymousUser(@AuthenticationPrincipal Principal principal) {
        if (isNull(principal)) {
            return UUID.randomUUID().toString();
        }
        return principal.getName();
    }

    @PostMapping("/chats")
    @ResponseStatus(OK)
    public void requestChatWithDoctor(@RequestBody ChatRequest chatRequest) {
        chatHandler.handleAnonymousChatRequest(chatRequest);
    }

}
