package com.fundlyze.backend.repository;

import com.fundlyze.backend.entity.FinancialStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FinancialStatementRepository extends JpaRepository<FinancialStatement, Long> {
    
List<FinancialStatement> findByCompanyIdOrderByFiscalYearDesc(Long companyId);

   List<FinancialStatement> findByCompanyIdAndPeriodType(Long companyId, String periodType);

   
}


