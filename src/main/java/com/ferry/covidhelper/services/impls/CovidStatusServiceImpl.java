package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.CovidStatus;
import com.ferry.covidhelper.repositories.CovidStatusRepository;
import com.ferry.covidhelper.services.CovidStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CovidStatusServiceImpl implements CovidStatusService {

    private final CovidStatusRepository statusRepository;

    @Override
    public List<CovidStatus> getByRegion(String region) {
        return statusRepository.findByRegion(region);
    }

    @Override
    public List<CovidStatus> getByState(String state) {
        return statusRepository.findByState(state);
    }

    @Override
    public List<CovidStatus> getByCity(String city) {
        return statusRepository.findByCity(city);
    }
}
