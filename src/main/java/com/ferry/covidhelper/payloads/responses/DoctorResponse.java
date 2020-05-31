package com.ferry.covidhelper.payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.domains.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DoctorResponse {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("nome")
    private final String name;

    @JsonProperty("crm")
    private final String crm;

    @JsonProperty("state")
    private final String state;

    @JsonProperty("specialty")
    private final String specialty;

    @JsonProperty("situation")
    private final String situation;

    public static DoctorResponse of(Doctor doctor) {
        return new DoctorResponse(
                doctor.getId(),
                doctor.getName(),
                doctor.getCrm(),
                doctor.getState(),
                doctor.getSpecialty(),
                doctor.getSituation());
    }
}
