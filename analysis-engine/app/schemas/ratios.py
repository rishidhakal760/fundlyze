from pydantic import BaseModel
from typing import Optional


class FinancialStatementInput(BaseModel):
    total_revenue: float
    net_profit: float
    operating_profit: float
    eps: float
    total_assets: float
    total_liabilities: float
    total_equity: float
    total_debt: float
    market_price: float
    shares_outstanding: int
    book_value_per_share: float
    dividend_per_share: Optional[float] = None


class RatioResult(BaseModel):
    roe: Optional[float] = None
    roa: Optional[float] = None
    price_to_earnings: Optional[float] = None
    price_to_book: Optional[float] = None
    debt_to_equity: Optional[float] = None
    net_profit_margin: Optional[float] = None
    operating_margin: Optional[float] = None
    dividend_yield: Optional[float] = None