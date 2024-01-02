package org.example.multimodule.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.example.multimodule.email.EmailService;
import org.example.multimodule.model.doctor.Doctor;
import org.example.multimodule.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final EmailService emailService;

    @PostConstruct
    public void initDoctor() {
        doctorRepository.saveAll(Stream.of(new Doctor(101L, "Jhon", "Cardiac")
                , new Doctor(102L, "Peter", "Eye")).collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors() {
        this.emailService.sendEmail();

        return doctorRepository.findAll();
    }
}