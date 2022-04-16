package com.company.interfaces;

public interface Pacient {
    public String showPacientInfo(com.company.entities.Pacient obj);
    public String tipAsigurare(com.company.entities.Pacient obj);
    public Boolean verificaFonduri(com.company.entities.Pacient obj); //returneaza true -> consultatia pacientului poate fi decontata, respectiv fals -> nu poate
    public int urgenta(com.company.entities.Pacient obj); //returneaza cat de urgenta este atentia medicala, avand in vedere diagnosticul pacientului
    public String showProgramari(com.company.entities.Pacient obj);


}
