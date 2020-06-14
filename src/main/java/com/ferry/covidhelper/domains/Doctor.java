package com.ferry.covidhelper.domains;

import com.ferry.covidhelper.payloads.requests.DoctorRegistrationRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "doctors")
public class Doctor {

    @Id
    private final String id;

    @Field("crm")
    @Indexed
    private final String crm;

    @Field("name")
    private final String name;

    @Field("specialty")
    private final String specialty;

    @Field("situation")
    private final String situation;

    @Indexed
    @Field("user")
    private final String user;

    public static Doctor of(DoctorRegistrationRequest request, User user) {
        return new Doctor(
                new ObjectId().toString(),
                request.getCrm(),
                request.getName(),
                request.getSpecialty(),
                request.getSituation(),
                user.getId()
        );
    }

}
