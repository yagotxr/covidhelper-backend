package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.CovidStatus;
import com.ferry.covidhelper.payloads.responses.CovidStatusResponse;
import com.ferry.covidhelper.services.CovidStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class CovidStatusController {

    private final CovidStatusService statusService;

    @GetMapping(value = "/informations", params = "region")
    @ResponseStatus(OK)
    public List<CovidStatusResponse> getRegionStatus(@RequestParam String region) {
        List<CovidStatus> statuses = statusService.getByRegion(region);
        return statuses.stream().map(CovidStatusResponse::of).collect(toList());
    }

    @GetMapping(value = "/informations", params = "state")
    @ResponseStatus(OK)
    public List<CovidStatusResponse> getStateStatus(@RequestParam String state) {
        List<CovidStatus> statuses = statusService.getByState(state);
        return statuses.stream().map(CovidStatusResponse::of).collect(toList());
    }

    @GetMapping(value = "/informations", params = "city")
    @ResponseStatus(OK)
    public List<CovidStatusResponse> getCityStatus(@RequestParam String city) {
        List<CovidStatus> statuses = statusService.getByCity(city);
        return statuses.stream().map(CovidStatusResponse::of).collect(toList());
    }
}
