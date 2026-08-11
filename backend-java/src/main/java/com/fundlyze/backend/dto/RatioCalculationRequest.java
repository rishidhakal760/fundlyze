package com.fundlyze.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class RatioCalculationRequest {

    @JsonProperty("total_revenue")
    private BigDecimal totalRevenue;

    @JsonProperty("net_profit")
    private BigDecimal netProfit;

    @JsonProperty("operating_profit")
    private BigDecimal operatingProfit;

    @JsonProperty("eps")
    private BigDecimal eps;

    @JsonProperty("total_assets")
    private BigDecimal totalAssets;

    @JsonProperty("total_liabilities")
    private BigDecimal totalLiabilities;

    @JsonProperty("total_equity")
    private BigDecimal totalEquity;

    @JsonProperty("total_debt")
    private BigDecimal totalDebt;

    @JsonProperty("market_price")
    private BigDecimal marketPrice;

    @JsonProperty("shares_outstanding")
    private Long sharesOutstanding;

    @JsonProperty("book_value_per_share")
    private BigDecimal bookValuePerShare;

    @JsonProperty("dividend_per_share")
    private BigDecimal dividendPerShare;

    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }

    public BigDecimal getNetProfit() { return netProfit; }
    public void setNetProfit(BigDecimal netProfit) { this.netProfit = netProfit; }

    public BigDecimal getOperatingProfit() { return operatingProfit; }
    public void setOperatingProfit(BigDecimal operatingProfit) { this.operatingProfit = operatingProfit; }

    public BigDecimal getEps() { return eps; }
    public void setEps(BigDecimal eps) { this.eps = eps; }

    public BigDecimal getTotalAssets() { return totalAssets; }
    public void setTotalAssets(BigDecimal totalAssets) { this.totalAssets = totalAssets; }

    public BigDecimal getTotalLiabilities() { return totalLiabilities; }
    public void setTotalLiabilities(BigDecimal totalLiabilities) { this.totalLiabilities = totalLiabilities; }

    public BigDecimal getTotalEquity() { return totalEquity; }
    public void setTotalEquity(BigDecimal totalEquity) { this.totalEquity = totalEquity; }

    public BigDecimal getTotalDebt() { return totalDebt; }
    public void setTotalDebt(BigDecimal totalDebt) { this.totalDebt = totalDebt; }

    public BigDecimal getMarketPrice() { return marketPrice; }
    public void setMarketPrice(BigDecimal marketPrice) { this.marketPrice = marketPrice; }

    public Long getSharesOutstanding() { return sharesOutstanding; }
    public void setSharesOutstanding(Long sharesOutstanding) { this.sharesOutstanding = sharesOutstanding; }

    public BigDecimal getBookValuePerShare() { return bookValuePerShare; }
    public void setBookValuePerShare(BigDecimal bookValuePerShare) { this.bookValuePerShare = bookValuePerShare; }

    public BigDecimal getDividendPerShare() { return dividendPerShare; }
    public void setDividendPerShare(BigDecimal dividendPerShare) { this.dividendPerShare = dividendPerShare; }
}