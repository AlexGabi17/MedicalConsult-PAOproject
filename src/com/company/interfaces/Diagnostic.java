package com.company.interfaces;


import java.util.ArrayList;

public interface Diagnostic{
    String toString(com.company.entities.Diagnostic diagnostic);
    void writeDiagnostic(ArrayList<com.company.entities.Diagnostic> productList);
    ArrayList<com.company.entities.Diagnostic> readDiagnostic();
}
