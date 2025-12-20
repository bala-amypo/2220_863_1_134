package com.example.demo.controller;

import com.example.demo.entity.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService deviationRuleService;

    public DeviationRuleController(DeviationRuleService deviationRuleService) {
        this.deviationRuleService = deviationRuleService;
    }

    @PostMapping
    public DeviationRule createRule(@RequestBody DeviationRule rule) {
        return deviationRuleService.createDeviationRule(rule);
    }

    @GetMapping("/{surgeryType}")
    public List<DeviationRule> getRules(@PathVariable String surgeryType) {
        return deviationRuleService.getRulesBySurgeryType(surgeryType);
    }
}
