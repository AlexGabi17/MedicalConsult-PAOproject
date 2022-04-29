package com.company.interfaces;

import com.company.entities.Diagnostic;

import java.util.ArrayList;

public interface Asigurare {
    public int getId(com.company.entities.Asigurare obj);
    public String getTipAsigurare(com.company.entities.Asigurare obj);
    public String getNumeCasaSanatate(com.company.entities.Asigurare obj);
    public String getDataExpirare(com.company.entities.Asigurare obj);

    public void changeTipAsigurare(com.company.entities.Asigurare obj, String tip);
    public void changeNumeCasaSanatate(com.company.entities.Asigurare obj, String casa);
    public void changeDataExpirare(com.company.entities.Asigurare obj, String dataExpirare);

    public String toString(com.company.entities.Asigurare asigurare);

    public void writeAsigurari(ArrayList<com.company.entities.Asigurare> productList);
    public void readAsigurari();
}
