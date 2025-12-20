package com.example.demo.service;

import com.example.demo.entity.RecoveryCurveProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RecoveryCurveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveService {
    private final RecoveryCurveRepository recoveryCurveRepository;
    public RecoveryCurveService(RecoveryCurveRepository recoveryCurveRepository) {
        this.recoveryCurveRepository = recoveryCurveRepository;
    }

    public RecoveryCurveProfile createRecoveryCurve(RecoveryCurveProfile profile) {
        if (profile.getExpectedPainLevel() < 0
                || profile.getExpectedMobilityLevel() < 0
                || profile.getExpectedFatigueLevel() < 0) {

            throw new IllegalArgumentException("Threshold must be non-negative");
        }

        return recoveryCurveRepository.save(profile);
    }
    public List<RecoveryCurveProfile> getRecoveryCurvesBySurgeryType(String surgeryType) {
        List<RecoveryCurveProfile> curves =
                recoveryCurveRepository.findBySurgeryType(surgeryType);
        if (curves.isEmpty()) {
            throw new ResourceNotFoundException("Recovery curve not found");
        }
        return curves;
    }
}
