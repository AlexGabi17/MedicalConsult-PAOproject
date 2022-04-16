package com.company;

import com.company.entities.*;
import com.company.services.*;


import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        //SIMULAM O BAZA DE DATE

        Triaj triaj_spital1 = new Triaj(1,"Ana");

        //Programari
        Programare[] programari_pacient1 = new Programare[10];


        //Spitale
        Spital spitalReginaMaria = new Spital(1,"Regina Maria", "Mihalache", triaj_spital1);

        //Doctori

        Doctor doc1 = new Doctor(1,"Ion",spitalReginaMaria,new Cabinet(1,true));
        Doctor doc2 = new Doctor(2,"Amalia",spitalReginaMaria,new Cabinet(2,true));

        Set<Doctor> doctori = new HashSet<Doctor>();
        doctori.add(doc1);
        doctori.add(doc2);
        System.out.println(doctori);

        //adaugare programari pentru un pacient
        programari_pacient1[0] = new Programare(12,2, 5, doc1);
        programari_pacient1[1] = new Programare(9,2,4, doc2);


        //Adaugare pacienti
        Pacient pacient1 = new Pacient(1,"Ionut", new Diagnostic(1,"raceala"), programari_pacient1,new Asigurare(23,"stat","CASMB","10 10 23"));

        System.out.println("Pacientul1 are asigurare de la " + pacient1.getAsigurare().getTipAsigurare());



        //


        // Initializare servicii

        PacientService pacientService = new PacientService();
        DoctorService doctorService = new DoctorService();
        AsigurareService asigurareService = new AsigurareService();
        RoomService roomService = new RoomService();
        TriajService triajService = new TriajService();

        //Apelam metode din servicii

        System.out.println(pacientService.showPacientInfo(pacient1));

        System.out.println(pacientService.showProgramari(pacient1));

        System.out.println("Inainte de modificare din serviciu -> nume:" + doctorService.getNume(doc1));

        doctorService.changeName(doc1,"Catalin");

        System.out.println("Dupa modificarea din serviciu -> nume:" + doctorService.getNume(doc1));

    }
}
