package services;

import entities.Cabinet;
import entities.Doctor;
import entities.Spital;
import interfaces.DoctorInterface;

public class DoctorService implements DoctorInterface {
    @Override
    public void changeName(Doctor obj, String nume) {
        obj.setNume(nume);
    }

    @Override
    public String showDoctor(Doctor obj) {
        return "Doctorul " + obj.getNume() + "cu id-ul " + obj.getId() + " lucreaza la spitalul " + obj.getSpital().getNume();
    }

    @Override
    public int getiId(Doctor obj) {
        return obj.getId();
    }

    @Override
    public Cabinet getCabinet(Doctor obj) {
        return obj.getCabinet();
    }

    @Override
    public String getNume(Doctor obj) {
        return obj.getNume();
    }

    @Override
    public Spital getSpital(Doctor obj) {
        return obj.getSpital();
    }
}
