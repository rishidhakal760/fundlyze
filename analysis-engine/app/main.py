from fastapi import FastAPI
from app.schemas.ratios import FinancialStatementInput, RatioResult
from app.services.ratio_calculator import calculate_ratios


app = FastAPI(title="Fundlyze Analysis Engine")


@app.get("/")
def read_root():
    return {"message": "Fundlyze Analysis Engine is running"}


@app.get("/health")
def health_check():
    return {"status": "healthy"}

@app.post("/api/ratios/calculate", response_model=RatioResult)
def calculate_financial_ratios(data: FinancialStatementInput):
    return calculate_ratios(data)