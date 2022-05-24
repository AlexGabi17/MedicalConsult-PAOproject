package com.company.entities;

public class Doctor {
    private int id;
    private String nume;
    private Spital spital;
    private Cabinet cabinet;

    public Doctor(int id, String nume, Spital spital, Cabinet cabinet) {
        this.id = id;
        this.nume = nume;
        this.spital = spital;
        this.cabinet = cabinet;
    }



    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpital(Spital spital) {
        this.spital = spital;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public int getId() {
        return id;
    }
    public String getNume() {
        return nume;
    }

    public Spital getSpital() {
        return spital;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

}
