package com.company.interfaces;


import com.company.entities.Diagnostic;

import java.util.List;

public interface IDiagnostic {
    String toString(Diagnostic diagnostic);
    void writeDiagnostic(List<Diagnostic> productList);
    List<Diagnostic> readDiagnostic();
}
