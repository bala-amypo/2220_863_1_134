package com.example.demo.service;
import com.example.demo.entity.PatientProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PatientProfileRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class PatientProfileService {
    private final PatientProfileRepository patientProfileRepository;
    public PatientProfileService(PatientProfileRepository patientProfileRepository) {

        this.patientProfileRepository = patientProfileRepository;

    }
    public PatientProfile createPatient(PatientProfile patientProfile) {

        if (patientProfileRepository.findByEmail(patientProfile.getEmail()).isPresent()) {

            throw new IllegalArgumentException("Email already exists");
        }
        patientProfile.setCreatedAt(LocalDateTime.now());
        patientProfile.setActive(true);
        return patientProfileRepository.save(patientProfile);
    }
    public List<PatientProfile> getAllPatients() {

        return patientProfileRepository.findAll();

    }
    public PatientProfile getPatientById(Long id) {

        return patientProfileRepository.findById(id)

        .orElseThrow(() ->
        )
        new ResourceNotFoundException("Patient not found"));

    }
    public PatientProfile getPatientByPatientId(String patientId) {

        return patientProfileRepository.findByPatientId(patientId)

        .orElseThrow(() ->
        )
        new ResourceNotFoundException("Patient not found"));

    }

}