package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.CovidStatus;

import java.util.List;

public interface CovidStatusService {

    List<CovidStatus> getByRegion(String region);

    List<CovidStatus> getByState(String state);

    List<CovidStatus> getByCity(String city);

}
