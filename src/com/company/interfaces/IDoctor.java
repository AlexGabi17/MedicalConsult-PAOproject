package com.company.interfaces;

import com.company.entities.Cabinet;
import com.company.entities.Doctor;
import com.company.entities.Spital;


public interface IDoctor {
    public String getNume(Doctor obj);
    public void changeName(Doctor obj, String nume);
}
