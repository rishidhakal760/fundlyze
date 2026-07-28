package com.fundlyze.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fundlyze.backend.repository.CompanyRepository;
import com.fundlyze.backend.entity.Company;
import java.util.List;


@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
}
