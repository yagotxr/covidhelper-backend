package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.CovidStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidStatusRepository extends MongoRepository<CovidStatus, String> {

    List<CovidStatus> findByRegion(String region);

    List<CovidStatus> findByState(String state);

    List<CovidStatus> findByCity(String region);

}
