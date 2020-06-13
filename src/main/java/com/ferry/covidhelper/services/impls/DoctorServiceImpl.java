package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.exceptions.NotFound;
import com.ferry.covidhelper.payloads.requests.DoctorRegistrationRequest;
import com.ferry.covidhelper.repositories.DoctorRepository;
import com.ferry.covidhelper.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor registerDoctor(DoctorRegistrationRequest registrationRequest) {
        Doctor doctor = Doctor.of(registrationRequest);
        return doctorRepository.insert(doctor);
    }

    @Override
    public void deleteDoctor(String crm) {
        Doctor doctor = getDoctorByCrm(crm);
        doctorRepository.delete(doctor);
    }


    private Doctor getDoctorByCrm(String crm) {
        return doctorRepository.findByCrm(crm)
                .orElseThrow(() -> new NotFound("Doctor not found"));
    }
}
