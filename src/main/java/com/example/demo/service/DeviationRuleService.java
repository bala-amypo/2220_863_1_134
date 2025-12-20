package com.example.demo.service;



import com.example.demo.entity.DeviationRule;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.repository.DeviationRuleRepository;

import org.springframework.stereotype.Service;



import java.util.List;



@Service

public class DeviationRuleService {



    private final DeviationRuleRepository deviationRuleRepository;



    public DeviationRuleService(DeviationRuleRepository deviationRuleRepository) {

        this.deviationRuleRepository = deviationRuleRepository;

        }



        // Create Deviation Rule

        public DeviationRule createDeviationRule(DeviationRule rule) {



            if (rule.getThresholdDeviation() == null || rule.getThresholdDeviation() <= 0) {

                throw new IllegalArgumentException("Threshold must be greater than zero");

                }



                rule.setActive(true);

                return deviationRuleRepository.save(rule);

                }



                // Get Rules by Surgery Type

                public List<DeviationRule> getRulesBySurgeryType(String surgeryType) {



                    List<DeviationRule> rules =

                    deviationRuleRepository.findBySurgeryType(surgeryType);



                    if (rules.isEmpty()) {

                        throw new ResourceNotFoundException("Deviation rule not found");

                        }



                        return rules;

                        }

                        }