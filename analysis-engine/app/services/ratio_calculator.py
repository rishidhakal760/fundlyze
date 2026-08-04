from app.schemas.ratios import FinancialStatementInput, RatioResult


def safe_divide(numerator: float, denominator: float) -> float | None:
    """Returns None instead of crashing when dividing by zero."""
    if denominator == 0:
        return None
    return round(numerator / denominator, 4)


def calculate_ratios(data: FinancialStatementInput) -> RatioResult:
    return RatioResult(
        roe=safe_divide(data.net_profit, data.total_equity)*100,
        roa=safe_divide(data.net_profit, data.total_assets)*100,
        price_to_earnings=safe_divide(data.market_price, data.eps),
        price_to_book=safe_divide(data.market_price, data.book_value_per_share),
        debt_to_equity=safe_divide(data.total_debt, data.total_equity),
        net_profit_margin=safe_divide(data.net_profit, data.total_revenue)*100,
        operating_margin=safe_divide(data.operating_profit, data.total_revenue)*100,
        dividend_yield=(
            safe_divide(data.dividend_per_share, data.market_price)
            if data.dividend_per_share is not None
            else None
        ),
    )