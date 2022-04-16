package com.company.entities;

public class Triaj extends Room{

    private String sefTriaj;

    public Triaj(int number, String sefTriaj) {
        super(number);
        this.sefTriaj = sefTriaj;
    }


    public void setSefTriaj(String sefTriaj) {
        this.sefTriaj = sefTriaj;
    }

    public String getSefTriaj() {
        return sefTriaj;
    }


}
