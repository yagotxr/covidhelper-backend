package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.DoctorRegistrationRequest;

public interface DoctorService {

    Doctor registerDoctor(DoctorRegistrationRequest registrationRequest, User user);

    Doctor getDoctor(String doctorId);

    void doctorExistsById(String doctorId);
}
