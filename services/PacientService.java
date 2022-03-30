package services;

import entities.Pacient;
import interfaces.PacientInterface;

public class PacientService implements PacientInterface {
    @Override
    public String showPacientInfo(Pacient obj) {
        String result = new String();
        result = "Pacientul " + obj.getNume() + " cu id-ul " + obj.getId() + " are diagnosticul " + obj.getDiagnostic().getDiagnostic();

        return result;
    }


    @Override
    public String tipAsigurare(Pacient obj) {
        return obj.getAsigurare().getTipAsigurare();
    }

    @Override
    public Boolean verificaFonduri(Pacient obj) {
        String tipAsigurare = obj.getAsigurare().getTipAsigurare();

        if(tipAsigurare == "stat")
        {
            return true; //statul acopera toate consultatiile
        }
        else{
            return false; //nu toate asigurarile private deconteaza orice tip de consultatie
        }
    }

    @Override
    public int urgenta(Pacient obj) {
        return obj.getDiagnostic().getUrgenta();
    }

    @Override
    public String showProgramari(Pacient obj) {
        String result = new String();
        result = "";
        int index = 0;
        while(obj.getProgramari()[index] != null){
            int zi = obj.getProgramari()[index].getZi();
            int luna = obj.getProgramari()[index].getLuna();
            int ora = obj.getProgramari()[index].getOra();

            result += "Pacientul " + obj.getNume() + " are o programarea nr. "+ index +" in data de " + zi +"/" + luna + " la ora " + ora + " "+ " la doctorul "+obj.getProgramari()[index].getDoctor().getNume()+"\n";
            index += 1;
        }

        return result;
    }

}
