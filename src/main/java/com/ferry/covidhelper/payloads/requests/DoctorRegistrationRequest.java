package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class DoctorRegistrationRequest {

    @JsonProperty("crm")
    private final String crm;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("specialty")
    private final String specialty;

    @JsonProperty("situation")
    private final String situation;

}
