package com.example.demo.repository;
import com.example.demo.entity.RecoveryCurveProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface RecoveryCurveRepository extends JpaRepository<RecoveryCurveProfile,Long>{
    Optional<PatientProfile>findByEmail(String email);
    Optional<PatientProfile>findByPatientId(String patientIf);
}