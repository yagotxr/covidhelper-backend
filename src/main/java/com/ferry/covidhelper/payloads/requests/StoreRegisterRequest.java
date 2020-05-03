package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.domains.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class StoreRegisterRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("street")
    private String street;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("addOn")
    private String addOn;

    @JsonProperty("addressNumber")
    private String addressNumber;

    @JsonProperty("phone")
    private String phone;

}
