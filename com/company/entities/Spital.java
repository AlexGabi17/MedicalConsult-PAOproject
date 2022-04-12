package com.company.entities;

public class Spital {
    private int id;
    private String nume;
    private String adresa;

    public void setTriaj(Triaj triaj) {
        this.triaj = triaj;
    }

    public Triaj getTriaj() {
        return triaj;
    }

    public Spital(int id, String nume, String adresa, Triaj triaj) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.triaj = triaj;
    }

    private Triaj triaj;

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

}
