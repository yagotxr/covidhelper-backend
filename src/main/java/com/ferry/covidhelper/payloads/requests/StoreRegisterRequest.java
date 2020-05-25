package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class StoreRegisterRequest {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("cnpj")
    private final String cnpj;

    @JsonProperty("zipCode")
    private final String zipCode;

    @JsonProperty("street")
    private final String street;

    @JsonProperty("city")
    private final String city;

    @JsonProperty("state")
    private final String state;

    @JsonProperty("addOn")
    private final String addOn;

    @JsonProperty("addressNumber")
    private final String addressNumber;

    @JsonProperty("phoneNumbers")
    private final String[] phoneNumbers;

}
