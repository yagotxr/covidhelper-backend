package com.ferry.covidhelper.chats;

import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.ChatRequest;
import com.ferry.covidhelper.security.user.UserPrincipal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class ChatUser {

    private final String id;
    private final String name;

    public static void of(ChatRequest request) {
        ChatUser chatUser = new ChatUser(
                "temp".concat(new ObjectId().toString()),
                request.getName()
        );

        User user = User.of(chatUser);
        UserPrincipal.create(user);
    }
}
