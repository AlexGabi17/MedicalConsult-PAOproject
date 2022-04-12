package com.company.interfaces;

import com.company.entities.Pacient;

public interface PacientInterface {
    public String showPacientInfo(Pacient obj);
    public String tipAsigurare(Pacient obj);
    public Boolean verificaFonduri(Pacient obj); //returneaza true -> consultatia pacientului poate fi decontata, respectiv fals -> nu poate
    public int urgenta(Pacient obj); //returneaza cat de urgenta este atentia medicala, avand in vedere diagnosticul pacientului
    public String showProgramari(Pacient obj);


}
