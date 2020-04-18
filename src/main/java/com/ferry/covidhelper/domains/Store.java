package com.ferry.covidhelper.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document(collection = "stores")
public class Store {

    @Id
    private String storeId;

    @Field("name")
    private String name;

    @Field("cnpj")
    private String cnpj;

    @Field("address")
    private String address;

    @Field("phone")
    private String phone;

    @Field("providerId")
    private String providerId;

}
