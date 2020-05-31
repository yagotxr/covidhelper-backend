package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.exceptions.BadRequest;
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
    public Doctor registerDoctor(DoctorRegistrationRequest registrationRequest, User user) {
        if (doctorExistsByCrm(registrationRequest.getCrm())) {
            throw new BadRequest("A doctor with this CRM has already been registered.");
        }
        Doctor doctor = Doctor.of(user, registrationRequest);
        return doctorRepository.insert(doctor);
    }

    @Override
    public Doctor getDoctor(String doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFound("Doctor not found"));
    }

    private boolean doctorExistsByCrm(String crm) {
        return doctorRepository.existsByCrm(crm);
    }

    private boolean doctorExistsById(String doctorId) {
        return doctorRepository.existsById(doctorId);
    }
}
