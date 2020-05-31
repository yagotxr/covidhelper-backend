package com.ferry.covidhelper.domains;

import com.ferry.covidhelper.payloads.requests.DoctorRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static lombok.AccessLevel.PRIVATE;

@Document(collection = "doctors")
@Getter
@AllArgsConstructor(access = PRIVATE)
public class Doctor {

    @Id
    private final String id;

    @Field("name")
    private final String name;

    @Field("userId")
    private final String userId;

    @Field("crm")
    @Indexed
    private final String crm;

    @Field("state")
    private final String state;

    @Field("specialty")
    private final String specialty;

    @Field("situation")
    private final String situation;

    public static Doctor of(User user, DoctorRegistrationRequest registrationRequest) {
        return new Doctor(
                new ObjectId().toString(),
                registrationRequest.getName(),
                user.getId(),
                registrationRequest.getCrm(),
                registrationRequest.getState(),
                registrationRequest.getSpecialty(),
                registrationRequest.getSituation()
        );
    }
}
