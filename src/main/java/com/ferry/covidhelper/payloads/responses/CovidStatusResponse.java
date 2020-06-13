package com.ferry.covidhelper.payloads.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.domains.CovidStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class CovidStatusResponse {

    @JsonProperty("regiao")
    private final String region;

    @JsonProperty("estado")
    private final String state;

    @JsonProperty("municipio")
    private final String city;

    @JsonProperty("data")
    private final LocalDate date;

    @JsonProperty("casosAcumulado")
    private final String totalCases;

    @JsonProperty("obitosAcumulado")
    private final String totalDeaths;

    public static CovidStatusResponse of(CovidStatus status) {
        return new CovidStatusResponse(
                status.getRegion(),
                status.getState(),
                status.getCity(),
                status.getDate(),
                status.getTotalCases(),
                status.getTotalDeaths()
        );
    }
}
