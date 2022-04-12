package com.company.entities;

public class Diagnostic {
    public void setUrgenta(int urgenta) {
        this.urgenta = urgenta;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public int getUrgenta() {
        return urgenta;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public Diagnostic(int urgenta, String diagnostic) {
        this.urgenta = urgenta;
        this.diagnostic = diagnostic;
    }

    private int urgenta; //pacientii care au nevoie de atentie imediata, atributului "urgenta" ii va fi alocat o valoare mai mare
    private String diagnostic;
}
