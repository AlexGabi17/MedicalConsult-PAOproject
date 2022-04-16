package com.company.services;

import com.company.entities.Cabinet;
import com.company.entities.Spital;
import com.company.interfaces.Doctor;

public class DoctorService implements Doctor {
    @Override
    public void changeName(com.company.entities.Doctor obj, String nume) {
        obj.setNume(nume);
    }

    @Override
    public String showDoctor(com.company.entities.Doctor obj) {
        return "Doctorul " + obj.getNume() + "cu id-ul " + obj.getId() + " lucreaza la spitalul " + obj.getSpital().getNume();
    }

    @Override
    public int getiId(com.company.entities.Doctor obj) {
        return obj.getId();
    }

    @Override
    public Cabinet getCabinet(com.company.entities.Doctor obj) {
        return obj.getCabinet();
    }

    @Override
    public String getNume(com.company.entities.Doctor obj) {
        return obj.getNume();
    }

    @Override
    public Spital getSpital(com.company.entities.Doctor obj) {
        return obj.getSpital();
    }
}
