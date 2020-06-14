package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.DoctorRegistrationRequest;

public interface DoctorService {

    Doctor registerDoctor(DoctorRegistrationRequest registrationRequest, User user);

    void deleteDoctor(String doctorId, User user);
}
