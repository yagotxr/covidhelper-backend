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
public class DoctorResponse {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("specialty")
    private final String specialty;

    @JsonProperty("picture")
    private final String picture;

    public static DoctorResponse of(Doctor doctor, User user) {
        return new DoctorResponse(
                doctor.getName(),
                doctor.getSpecialty(),
                user.getPicture()
        );
    }

}
