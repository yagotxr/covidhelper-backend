package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    boolean existsByCrm(String crm);
}
