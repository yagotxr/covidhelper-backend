package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    Optional<Doctor> findByCrm(String crm);
}
