package com.fundlyze.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fundlyze.backend.entity.Company;


import java.util.Optional;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


List<Company> findByNameContainingIgnoreCase(String name);

Optional<Company> findBySymbol(String symbol);

List<Company> findBySectorContainingIgnoreCase(String sector);

boolean existsBySymbol(String symbol);


}
