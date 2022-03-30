package interfaces;

import entities.Cabinet;
import entities.Doctor;
import entities.Spital;


public interface DoctorInterface {
    public Spital getSpital(Doctor obj);
    public String getNume(Doctor obj);
    public Cabinet getCabinet(Doctor obj);
    public int getiId(Doctor obj);
    public String showDoctor(Doctor obj);
    public void changeName(Doctor obj, String nume);
}
