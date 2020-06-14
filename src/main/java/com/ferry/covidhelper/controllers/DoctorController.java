package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.Doctor;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.DoctorRegistrationRequest;
import com.ferry.covidhelper.payloads.responses.DoctorProfileResponse;
import com.ferry.covidhelper.payloads.responses.DoctorResponse;
import com.ferry.covidhelper.security.user.UserPrincipal;
import com.ferry.covidhelper.services.DoctorService;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final UserService userService;

    @PostMapping("account/doctors")
    @ResponseStatus(CREATED)
    public DoctorProfileResponse registerDoctor(@AuthenticationPrincipal UserPrincipal principal,
                                                @RequestBody DoctorRegistrationRequest registrationRequest) {
        User user = userService.findUser(principal.getName());
        Doctor doctor = doctorService.registerDoctor(registrationRequest, user);
        return DoctorProfileResponse.of(doctor, user);
    }

    @DeleteMapping("/account/doctors/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteDoctor(@AuthenticationPrincipal UserPrincipal principal,
                             @PathVariable("id") String doctorId) {
        User user = userService.findUser(principal.getName());
        doctorService.deleteDoctor(doctorId, user);
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(OK)
    public DoctorResponse getDoctor(@PathVariable("id") String doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        User user = userService.findUser(doctor.getUser());
        return DoctorResponse.of(doctor, user);
    }

}
