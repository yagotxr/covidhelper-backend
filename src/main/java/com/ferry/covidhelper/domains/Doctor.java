package com.ferry.covidhelper.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "doctors")
@Getter
@AllArgsConstructor
public class Doctor {

    @Id
    private final String id;

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

}
