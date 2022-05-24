package com.company.services;

import com.company.entities.Cabinet;
import com.company.entities.Doctor;
import com.company.entities.Spital;
import com.company.interfaces.IDoctor;

public class DoctorService implements IDoctor {

    private static DoctorService single_instance = null;

    private DoctorService(){

    }

    public static DoctorService getInstance()
    {
        if (single_instance == null) {
            single_instance = new DoctorService();
        }
        return single_instance;
    }

    @Override
    public void changeName(Doctor obj, String nume) {
        obj.setNume(nume);
    }



    @Override
    public String getNume(Doctor obj) {
        return obj.getNume();
    }


}
