package com.company.interfaces;

public interface Asigurare {
    public int getId(com.company.entities.Asigurare obj);
    public String getTipAsigurare(com.company.entities.Asigurare obj);
    public String getNumeCasaSanatate(com.company.entities.Asigurare obj);
    public String getDataExpirare(com.company.entities.Asigurare obj);

    public void changeTipAsigurare(com.company.entities.Asigurare obj, String tip);
    public void changeNumeCasaSanatate(com.company.entities.Asigurare obj, String casa);
    public void changeDataExpirare(com.company.entities.Asigurare obj, String dataExpirare);
}
