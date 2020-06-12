package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.exceptions.BadRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ChatRequest {

    @JsonProperty("requesterName")
    private final String requesterName;
    @JsonProperty("doctorId")
    private final String doctorId;
    @Setter
    @JsonProperty("requesterId")
    private String requesterId;

    public ChatRequest(String requesterId, String requesterName, String doctorId) {
        if (requesterName.isEmpty()) {
            throw new BadRequest("The requester name is expected.");
        }
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.doctorId = doctorId;
    }
}
