package com.fundlyze.backend.controller;

import com.fundlyze.backend.dto.CompanyDto;
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
    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }
    

    private CompanyDto toDto(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getSymbol(),
                company.getName(),
                company.getSector(),
                company.getCreatedAt(),
                company.getUpdatedAt()
        );
    }
}

