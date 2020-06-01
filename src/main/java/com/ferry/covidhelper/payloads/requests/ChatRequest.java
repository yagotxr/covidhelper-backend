package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.exceptions.BadRequest;
import lombok.Getter;

@Getter
public class ChatRequest {

    @JsonProperty("name")
    private final String name;

    public ChatRequest(String name) {
        if (name.isEmpty()) {
            throw new BadRequest("A name must be inserted.");
        }
        this.name = name;
    }
}
