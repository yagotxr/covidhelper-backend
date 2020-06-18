package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    Optional<Doctor> findByCrm(String crm);

    Optional<Doctor> findByUser(String userId);

    boolean existsByCrm(String crm);

    boolean existsByUser(String userId);
}
