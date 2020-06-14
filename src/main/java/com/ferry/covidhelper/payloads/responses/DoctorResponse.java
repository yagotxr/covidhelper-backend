package com.ferry.covidhelper.payloads.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.domains.Doctor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator, access = AccessLevel.PRIVATE)
public class DoctorResponse {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("crm")
    private final String crm;

    @JsonProperty("specialty")
    private final String specialty;

    @JsonProperty("situation")
    private final String situation;

    public static DoctorResponse of(Doctor doctor) {
        return new DoctorResponse(
                doctor.getId(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                doctor.getSituation()
        );
    }
}
