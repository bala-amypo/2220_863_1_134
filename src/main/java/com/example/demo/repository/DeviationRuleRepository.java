package com.example.demo.repository;
import com.example.demo.entity.RecoveryCurveProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RecoveryCurveRepository extends JpaRepository<RecoveryCurveProfile,Long>{
    List<RecoveryCurveProfile>findBySurgeryType(String surgeryType);
}