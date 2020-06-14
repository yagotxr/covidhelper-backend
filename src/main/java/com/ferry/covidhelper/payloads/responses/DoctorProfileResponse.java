package com.ferry.covidhelper.payloads.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.domains.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator, access = AccessLevel.PRIVATE)
public class DoctorProfileResponse {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("crm")
    private final String crm;

    @JsonProperty("specialty")
    private final String specialty;

    @JsonProperty("situation")
    private final String situation;

    @JsonProperty("picture")
    private final String picture;

    public static DoctorProfileResponse of(Doctor doctor, User user) {
        return new DoctorProfileResponse(
                doctor.getId(),
                doctor.getCrm(),
                doctor.getName(),
                doctor.getSpecialty(),
                doctor.getSituation(),
                user.getPicture()
        );
    }
}
