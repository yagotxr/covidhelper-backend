package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.exceptions.BadRequest;
import com.ferry.covidhelper.exceptions.Forbidden;
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
        if (isRegistered(registrationRequest.getCrm())) {
            throw new BadRequest("A Doctor with this CRM has already been registered.");
        }
        if (hasDoctorInAccount(user)) {
            throw new BadRequest("This account has already a Doctor connected.");
        }
        Doctor doctor = Doctor.of(registrationRequest, user);
        return doctorRepository.insert(doctor);
    }

    @Override
    public void deleteDoctor(String doctorId, User user) {
        Doctor doctor = getDoctorById(doctorId);
        if (isRelatedToUser(user, doctor)) {
            doctorRepository.delete(doctor);
        }
    }

    @Override
    public Doctor getDoctorByUser(String userId) {
        return doctorRepository.findByUser(userId).orElse(null);
    }

    @Override
    public Doctor getDoctorById(String id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new NotFound("Doctor not found."));
    }

    public Doctor getDoctorByCrm(String crm) {
        return doctorRepository.findByCrm(crm)
                .orElseThrow(() -> new NotFound("Doctor not found."));
    }

    private boolean isRelatedToUser(User user, Doctor doctor) {
        if (!user.getId().equals(doctor.getUser())) {
            throw new Forbidden("Doctor is not related to this account.");
        }
        return true;
    }

    private boolean isRegistered(String crm) {
        return doctorRepository.existsByCrm(crm);
    }

    private boolean hasDoctorInAccount(User user) {
        return doctorRepository.existsByUser(user.getId());
    }


}
