-- Users table: stores registered accounts
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);

-- Companies table: NEPSE company master list
CREATE TABLE companies (
    id BIGSERIAL PRIMARY KEY,
    symbol VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    sector VARCHAR(100),
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE INDEX idx_companies_symbol ON companies(symbol);
CREATE INDEX idx_companies_name ON companies(name);

-- Financial statements: raw yearly/quarterly data per company
CREATE TABLE financial_statements (
    id BIGSERIAL PRIMARY KEY,
    company_id BIGINT NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    fiscal_year VARCHAR(10) NOT NULL,
    period_type VARCHAR(20) NOT NULL DEFAULT 'ANNUAL',

    total_revenue NUMERIC(20,2),
    net_profit NUMERIC(20,2),
    operating_profit NUMERIC(20,2),
    eps NUMERIC(10,2),

    total_assets NUMERIC(20,2),
    total_liabilities NUMERIC(20,2),
    total_equity NUMERIC(20,2),
    total_debt NUMERIC(20,2),

    market_price NUMERIC(10,2),
    shares_outstanding BIGINT,
    book_value_per_share NUMERIC(10,2),

    dividend_per_share NUMERIC(10,2),

    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),

    UNIQUE(company_id, fiscal_year, period_type)
);

CREATE INDEX idx_financial_statements_company ON financial_statements(company_id);

-- Watchlists: which companies a user is tracking
CREATE TABLE watchlists (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    company_id BIGINT NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    added_at TIMESTAMP NOT NULL DEFAULT now(),

    UNIQUE(user_id, company_id)
);

CREATE INDEX idx_watchlists_user ON watchlists(user_id);