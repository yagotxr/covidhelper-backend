package com.ferry.covidhelper.chats;

import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.MessageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.time.ZoneOffset.UTC;

@Getter
@AllArgsConstructor
public class Message {

    private final String senderName;
    private final LocalDateTime sendDate;
    private final String content;

    public static Message build(MessageRequest request, User user) {
        return new Message(
                user.getName(),
                now(UTC),
                request.getContent()
        );
    }
}
