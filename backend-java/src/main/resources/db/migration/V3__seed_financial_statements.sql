-- NABIL Bank (company_id = 1) — two fiscal years
INSERT INTO financial_statements (
    company_id, fiscal_year, period_type,
    total_revenue, net_profit, operating_profit, eps,
    total_assets, total_liabilities, total_equity, total_debt,
    market_price, shares_outstanding, book_value_per_share, dividend_per_share
) VALUES
(1, '2080/81', 'ANNUAL',
    18500000000, 4200000000, 5100000000, 45.20,
    350000000000, 310000000000, 40000000000, 0,
    850.00, 93000000, 430.10, 15.00),

(1, '2081/82', 'ANNUAL',
    20100000000, 4650000000, 5600000000, 49.80,
    378000000000, 334000000000, 44000000000, 0,
    920.00, 93000000, 473.20, 18.00);

-- Nepal Telecom (company_id = 3) — two fiscal years
INSERT INTO financial_statements (
    company_id, fiscal_year, period_type,
    total_revenue, net_profit, operating_profit, eps,
    total_assets, total_liabilities, total_equity, total_debt,
    market_price, shares_outstanding, book_value_per_share, dividend_per_share
) VALUES
(3, '2080/81', 'ANNUAL',
    45000000000, 8200000000, 11000000000, 32.10,
    120000000000, 45000000000, 75000000000, 5000000000,
    780.00, 255000000, 294.10, 25.00),

(3, '2081/82', 'ANNUAL',
    47500000000, 8900000000, 11800000000, 34.90,
    128000000000, 46500000000, 81500000000, 4500000000,
    810.00, 255000000, 319.60, 27.00);