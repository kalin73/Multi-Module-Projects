package org.example.multimodule.web;

import lombok.RequiredArgsConstructor;

import org.example.multimodule.model.doctor.Doctor;
import org.example.multimodule.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return this.doctorService.getDoctors();
    }

}
