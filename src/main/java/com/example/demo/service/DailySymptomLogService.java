package com.example.demo.service;
import com.example.demo.entity.DailySymptomLog;
import com.example.demo.entity.PatientProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repoesitory.PatientProfileRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class DailySymptomLogService {

    private final DailySymptomLogRepository dailySymptomLogRepository;

    private final PatientProfileRepository patientProfileRepository;

    public DailySymptomLogService(DailySymptomLogRepository dailySymptomLogRepository,
    )
    PatientProfileRepository patientProfileRepository) {

        this.dailySymptomLogRepository = dailySymptomLogRepository;

        this.patientProfileRepository = patientProfileRepository;

    }
    public DailySymptomLog createDailyLog(Long patientId, DailySymptomLog log) {

        if (log.getLogDate().isAfter(LocalDate.now())) {

            throw new IllegalArgumentException("Cannot log symptoms for future date");

            }

            PatientProfile patient = patientProfileRepository.findById(patientId)

            .orElseThrow(() ->
            )
            new ResourceNotFoundException("Patient not found"));

            log.setPatient(patient);

            log.setSubmittedAt(LocalDateTime.now());

            return dailySymptomLogRepository.save(log);

            }

            public List<DailySymptomLog> getLogsByPatientId(Long patientId) {

                if (!patientProfileRepository.existsById(patientId)) {

                    throw new ResourceNotFoundException("Patient not found");

                    }

                    return dailySymptomLogRepository.findByPatientId(patientId);

                    }

}