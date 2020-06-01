package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class MessageRequest {

    @JsonProperty("content")
    private final String content;
}
