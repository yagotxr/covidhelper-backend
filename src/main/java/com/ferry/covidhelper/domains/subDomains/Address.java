package com.ferry.covidhelper.domains.subDomains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class Address {

    @Field("zipCode")
    private String zipCode;

    @Field("street")
    private String street;

    @Field("city")
    private String city;

    @Field("state")
    private String state;

    @Field("addOn")
    private String addOn;

    @Field("addressNumber")
    private String addressNumber;

}
