package com.company.entities;

public class Programare {
    private int ora;
    private int zi;
    private Doctor doctor; //doctorul la care e facuta programarea
    private int luna;
    public Programare(int ora, int zi, int luna,  Doctor doctor) {
        this.ora = ora;
        this.zi = zi;
        this.doctor = doctor;
        this.luna = luna;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public Doctor getDoctor() {
        return doctor;
    }


    public int getOra() {
        return ora;
    }

    public int getZi() {
        return zi;
    }

    public int getLuna() {
        return luna;
    }

}
