package com.company.interfaces;

import com.company.entities.Cabinet;
import com.company.entities.Spital;


public interface Doctor {
    public Spital getSpital(com.company.entities.Doctor obj);
    public String getNume(com.company.entities.Doctor obj);
    public Cabinet getCabinet(com.company.entities.Doctor obj);
    public int getiId(com.company.entities.Doctor obj);
    public String showDoctor(com.company.entities.Doctor obj);
    public void changeName(com.company.entities.Doctor obj, String nume);
}
