package com.fundlyze.backend.controller;

import com.fundlyze.backend.dto.FinancialStatementDto;
import com.fundlyze.backend.entity.FinancialStatement;
import com.fundlyze.backend.repository.FinancialStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies/{companyId}/financial-statements")
public class FinancialStatementController {

    private final FinancialStatementRepository financialStatementRepository;

    @Autowired
    public FinancialStatementController(FinancialStatementRepository financialStatementRepository) {
        this.financialStatementRepository = financialStatementRepository;
    }

    @GetMapping
    public List<FinancialStatementDto> getStatementsForCompany(@PathVariable Long companyId) {
        return financialStatementRepository.findByCompanyIdOrderByFiscalYearDesc(companyId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private FinancialStatementDto toDto(FinancialStatement fs) {
        FinancialStatementDto dto = new FinancialStatementDto();
        dto.setId(fs.getId());
        dto.setCompanyId(fs.getCompany().getId());
        dto.setCompanySymbol(fs.getCompany().getSymbol());
        dto.setFiscalYear(fs.getFiscalYear());
        dto.setPeriodType(fs.getPeriodType());
        dto.setTotalRevenue(fs.getTotalRevenue());
        dto.setNetProfit(fs.getNetProfit());
        dto.setOperatingProfit(fs.getOperatingProfit());
        dto.setEps(fs.getEps());
        dto.setTotalAssets(fs.getTotalAssets());
        dto.setTotalLiabilities(fs.getTotalLiabilities());
        dto.setTotalEquity(fs.getTotalEquity());
        dto.setTotalDebt(fs.getTotalDebt());
        dto.setMarketPrice(fs.getMarketPrice());
        dto.setSharesOutstanding(fs.getSharesOutstanding());
        dto.setBookValuePerShare(fs.getBookValuePerShare());
        dto.setDividendPerShare(fs.getDividendPerShare());
        dto.setCreatedAt(fs.getCreatedAt());
        dto.setUpdatedAt(fs.getUpdatedAt());
        return dto;
    }
}