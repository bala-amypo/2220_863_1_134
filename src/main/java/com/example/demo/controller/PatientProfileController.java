package com.example.demo.controller;

import com.example.demo.entity.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    private final PatientProfileService patientProfileService;

    public PatientProfileController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }

    @PostMapping
    public PatientProfile createPatient(@RequestBody PatientProfile patientProfile) {
        return patientProfileService.createPatient(patientProfile);
    }

    @GetMapping
    public List<PatientProfile> getAllPatients() {
        return patientProfileService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientProfile getPatientById(@PathVariable Long id) {
        return patientProfileService.getPatientById(id);
    }

    @GetMapping("/patient-id/{patientId}")
    public PatientProfile getPatientByPatientId(@PathVariable String patientId) {
        return patientProfileService.getPatientByPatientId(patientId);
    }
}
