package com.fundlyze.backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RatioResultDto {

    private Double roe;
    private Double roa;
    private Double priceToEarnings;
    private Double priceToBook;
    private Double debtToEquity;
    private Double netProfitMargin;
    private Double operatingMargin;
    private Double dividendYield;

    public Double getRoe() {
        return roe;
    }

    public void setRoe(Double roe) {
        this.roe = roe;
    }

    public Double getRoa() {
        return roa;
    }

    public void setRoa(Double roa) {
        this.roa = roa;
    }

    public Double getPriceToEarnings() {
        return priceToEarnings;
    }

    public void setPriceToEarnings(Double priceToEarnings) {
        this.priceToEarnings = priceToEarnings;
    }

    public Double getPriceToBook() {
        return priceToBook;
    }

    public void setPriceToBook(Double priceToBook) {
        this.priceToBook = priceToBook;
    }

    public Double getDebtToEquity() {
        return debtToEquity;
    }

    public void setDebtToEquity(Double debtToEquity) {
        this.debtToEquity = debtToEquity;
    }

    public Double getNetProfitMargin() {
        return netProfitMargin;
    }

    public void setNetProfitMargin(Double netProfitMargin) {
        this.netProfitMargin = netProfitMargin;
    }

    public Double getOperatingMargin() {
        return operatingMargin;
    }

    public void setOperatingMargin(Double operatingMargin) {
        this.operatingMargin = operatingMargin;
    }

    public Double getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(Double dividendYield) {
        this.dividendYield = dividendYield;
    }
}