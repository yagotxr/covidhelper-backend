package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.exceptions.BadRequest;
import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.isAnyBlank;

@Getter
public class ProductRegistrationRequest {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("stock")
    private final long stock;

    @JsonCreator
    public ProductRegistrationRequest(String name, String description, long stock) {
        if (isAnyBlank(name, description)) {
            throw new BadRequest("Please, a name and a description must be provided.");
        }
        this.name = name;
        this.description = description;
        this.stock = stock;
    }
}
