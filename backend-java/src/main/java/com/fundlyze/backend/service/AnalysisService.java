package com.fundlyze.backend.service;

import com.fundlyze.backend.dto.RatioCalculationRequest;
import com.fundlyze.backend.dto.RatioResultDto;
import com.fundlyze.backend.entity.FinancialStatement;
import com.fundlyze.backend.repository.FinancialStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnalysisService {

    private final FinancialStatementRepository financialStatementRepository;
    private final RestClient analysisEngineRestClient;

    @Autowired
    public AnalysisService(FinancialStatementRepository financialStatementRepository,
                            RestClient analysisEngineRestClient) {
        this.financialStatementRepository = financialStatementRepository;
        this.analysisEngineRestClient = analysisEngineRestClient;
    }

    public RatioResultDto analyzeCompany(Long companyId) {
        List<FinancialStatement> statements =
                financialStatementRepository.findByCompanyIdOrderByFiscalYearDesc(companyId);

        if (statements.isEmpty()) {
            throw new NoSuchElementException(
                    "No financial statements found for company id: " + companyId);
        }

        FinancialStatement latest = statements.get(0);

        RatioCalculationRequest request = toRequest(latest);

        return analysisEngineRestClient.post()
                .uri("/api/ratios/calculate")
                .body(request)
                .retrieve()
                .body(RatioResultDto.class);
    }

    private RatioCalculationRequest toRequest(FinancialStatement fs) {
        RatioCalculationRequest request = new RatioCalculationRequest();
        request.setTotalRevenue(fs.getTotalRevenue());
        request.setNetProfit(fs.getNetProfit());
        request.setOperatingProfit(fs.getOperatingProfit());
        request.setEps(fs.getEps());
        request.setTotalAssets(fs.getTotalAssets());
        request.setTotalLiabilities(fs.getTotalLiabilities());
        request.setTotalEquity(fs.getTotalEquity());
        request.setTotalDebt(fs.getTotalDebt());
        request.setMarketPrice(fs.getMarketPrice());
        request.setSharesOutstanding(fs.getSharesOutstanding());
        request.setBookValuePerShare(fs.getBookValuePerShare());
        request.setDividendPerShare(fs.getDividendPerShare());
        return request;
    }
}