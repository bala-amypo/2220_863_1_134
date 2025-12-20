package com.example.demo.controller;

import com.example.demo.entity.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveController {

    private final RecoveryCurveService recoveryCurveService;

    public RecoveryCurveController(RecoveryCurveService recoveryCurveService) {
        this.recoveryCurveService = recoveryCurveService;
    }

    @PostMapping
    public RecoveryCurveProfile createCurve(@RequestBody RecoveryCurveProfile profile) {
        return recoveryCurveService.createRecoveryCurve(profile);
    }

    @GetMapping("/{surgeryType}")
    public List<RecoveryCurveProfile> getBySurgeryType(@PathVariable String surgeryType) {
        return recoveryCurveService.getRecoveryCurvesBySurgeryType(surgeryType);
    }
}
