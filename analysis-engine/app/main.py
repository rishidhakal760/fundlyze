from fastapi import FastAPI

app = FastAPI(title="Fundlyze Analysis Engine")


@app.get("/")
def read_root():
    return {"message": "Fundlyze Analysis Engine is running"}


@app.get("/health")
def health_check():
    return {"status": "healthy"}