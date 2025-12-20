package com.example.demo.service;
import com.example.demo.entity.ClinicalAlert;
import com.example.demo.entity.PatientProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.repository.PatientProfileRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class ClinicalAlertService {

    private final ClinicalAlertRepository clinicalAlertRepository;

    private final PatientProfileRepository patientProfileRepository;



    public ClinicalAlertService(ClinicalAlertRepository clinicalAlertRepository,
    
    PatientProfileRepository patientProfileRepository){

        this.clinicalAlertRepository = clinicalAlertRepository;

        this.patientProfileRepository = patientProfileRepository;

    }

    public ClinicalAlert createAlert(Long patientId, ClinicalAlert alert) {



        PatientProfile patient = patientProfileRepository.findById(patientId)

        .orElseThrow(() ->
        )
        new ResourceNotFoundException("Patient not found");

        alert.setPatient(patient);
        alert.setAlertDate(LocalDate.now());
        alert.setResolved(false);

        return clinicalAlertRepository.save(alert);

        }
        public List<ClinicalAlert> getAlertsByPatientId(Long patientId) {

            if (!patientProfileRepository.existsById(patientId)) {

                throw new ResourceNotFoundException("Patient not found");
                }
                return clinicalAlertRepository.findByPatientId(patientId);
                }

                }