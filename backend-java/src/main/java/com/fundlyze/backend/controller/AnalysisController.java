package com.fundlyze.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundlyze.backend.dto.RatioResultDto;
import com.fundlyze.backend.service.AnalysisService;


@RestController
@RequestMapping("/api/companies/{companyId}/analysis")
public class AnalysisController {
 
    private final AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }
     @GetMapping
     public RatioResultDto getCompanyAnalysis(@PathVariable Long companyId) {
        return analysisService.analyzeCompany(companyId);
     }

}
