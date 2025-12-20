package com.example.demo.service;

import com.example.demo.entity.RecoveryCurveProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveService {

    private final RecoveryCurveProfileRepository recoveryCurveProfileRepository;

    public RecoveryCurveService(RecoveryCurveProfileRepository recoveryCurveProfileRepository) {
        this.recoveryCurveProfileRepository = recoveryCurveProfileRepository;
    }

    // Create Recovery Curve
    public RecoveryCurveProfile createRecoveryCurve(RecoveryCurveProfile profile) {

        if (profile.getExpectedPainLevel() < 0
                || profile.getExpectedMobilityLevel() < 0
                || profile.getExpectedFatigueLevel() < 0) {

            throw new IllegalArgumentException("Threshold must be non-negative");
        }

        return recoveryCurveProfileRepository.save(profile);
    }

    // Get Recovery Curves by Surgery Type
    public List<RecoveryCurveProfile> getRecoveryCurvesBySurgeryType(String surgeryType) {

        List<RecoveryCurveProfile> curves =
                recoveryCurveProfileRepository.findBySurgeryType(surgeryType);

        if (curves.isEmpty()) {
            throw new ResourceNotFoundException("Recovery curve not found");
        }

        return curves;
    }
}
