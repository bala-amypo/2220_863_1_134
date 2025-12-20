package com.example.demo.controller;

import com.example.demo.entity.ClinicalAlert;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService clinicalAlertService;

    public ClinicalAlertController(ClinicalAlertService clinicalAlertService) {
        this.clinicalAlertService = clinicalAlertService;
    }

    @PostMapping("/{patientId}")
    public ClinicalAlert createAlert(
            @PathVariable Long patientId,
            @RequestBody ClinicalAlert alert) {

        return clinicalAlertService.createAlert(patientId, alert);
    }

    @GetMapping("/{patientId}")
    public List<ClinicalAlert> getAlerts(@PathVariable Long patientId) {
        return clinicalAlertService.getAlertsByPatientId(patientId);
    }
}
