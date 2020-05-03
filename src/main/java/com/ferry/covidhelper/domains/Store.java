package com.ferry.covidhelper.domains;

import com.ferry.covidhelper.domains.subDomains.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "stores")
public class Store {

    @Id
    private String storeId;

    @Field("name")
    private String name;

    @Field("cnpj")
    private String cnpj;

    @Field("address")
    private Address address;

    @Field("phone")
    private String phone;

    @Field("providerId")
    private String providerId;

}
