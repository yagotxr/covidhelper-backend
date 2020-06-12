package com.ferry.covidhelper.chats;

import com.ferry.covidhelper.payloads.requests.ChatRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
@AllArgsConstructor
public class Chat {

    private final String chatId;
    private final String userId;
    private final String doctorId;

    public static Chat newChat(ChatRequest request) {
        return new Chat(
                new ObjectId().toString(),
                request.getRequesterId(),
                request.getDoctorId()
        );
    }
}
