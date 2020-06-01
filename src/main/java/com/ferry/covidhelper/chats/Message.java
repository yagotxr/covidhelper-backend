package com.ferry.covidhelper.chats;

import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.MessageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.time.ZoneOffset.UTC;

@Getter
@AllArgsConstructor
public class Message {

    private final String messageId;
    private final String senderName;
    private final LocalDateTime sentDate;
    private final String content;

    public static Message build(MessageRequest messageRequest, User fromUser) {
        return new Message(
                new ObjectId().toString(),
                fromUser.getName(),
                now(UTC),
                messageRequest.getContent()
        );
    }
}
