package com.ferry.covidhelper.domains;

import com.ferry.covidhelper.security.user.OAuth2UserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;

@Getter
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private final String id;

    @Email
    @Field("email")
    private final String email;

    @Field("name")
    @Setter
    private String name;

//    @Field("provider")
//    private AuthProvider provider;

    @Field("picture")
    @Setter
    private String picture;

    @Field("providerId")
    private final String providerId;

    public static User of(OAuth2UserInfo oAuth2UserInfo){
        return new User(
                new ObjectId().toString(),
                oAuth2UserInfo.getEmail(),
                oAuth2UserInfo.getName(),
                oAuth2UserInfo.getImageUrl(),
                oAuth2UserInfo.getId()
        );
    }
}