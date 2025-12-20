package com.example.demo.controller;

import com.example.demo.entity.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptom-logs")
public class DailySymptomLogController {

    private final DailySymptomLogService dailySymptomLogService;

    public DailySymptomLogController(DailySymptomLogService dailySymptomLogService) {
        this.dailySymptomLogService = dailySymptomLogService;
    }

    @PostMapping("/{patientId}")
    public DailySymptomLog createLog(
            @PathVariable Long patientId,
            @RequestBody DailySymptomLog log) {

        return dailySymptomLogService.createDailyLog(patientId, log);
    }

    @GetMapping("/{patientId}")
    public List<DailySymptomLog> getLogs(@PathVariable Long patientId) {
        return dailySymptomLogService.getLogsByPatientId(patientId);
    }
}
