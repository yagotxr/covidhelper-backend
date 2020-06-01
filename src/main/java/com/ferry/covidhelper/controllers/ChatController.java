package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.chats.ChatUser;
import com.ferry.covidhelper.chats.Message;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.ChatRequest;
import com.ferry.covidhelper.payloads.requests.MessageRequest;
import com.ferry.covidhelper.security.user.UserPrincipal;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static java.util.UUID.randomUUID;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations sendingOperations;
    private final UserService userService;

    @MessageMapping("/send/{chatId}")
    public Message sendMessage(@AuthenticationPrincipal UserPrincipal principal,
                               @DestinationVariable String chatId,
                               MessageRequest messageRequest) {
        User user;
        if (principal.getName().contains("temp")) {
            user =
        } else {
            user = userService.findUser(principal.getName());
        }
        Message message = Message.build(messageRequest, user);
        sendingOperations.convertAndSend();
    }

    @PostMapping("/chats/doctors/{doctorId}")
    @ResponseStatus(OK)
    public String requestChatWithDoctor(@RequestBody ChatRequest chatRequest,
                                        @PathVariable("doctorId") String doctorId) {
        ChatUser.of(chatRequest);
        String chatId = randomUUID().toString();
        String destination = "/invites/" + doctorId;
        sendingOperations.convertAndSend(destination, chatId);
        return chatId;
    }

}
