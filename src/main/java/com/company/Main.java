package com.company;

import com.company.entities.*;
import com.company.repositories.AsigurareRepository;
import com.company.repositories.DiagnosticRepository;
import com.company.services.*;


import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
//        System.out.println(doctori);

        //adaugare programari pentru un pacient
        programari_pacient1[0] = new Programare(12,2, 5, doc1);
        programari_pacient1[1] = new Programare(9,2,4, doc2);


        //Adaugare pacienti
        Pacient pacient1 = new Pacient(1,"Ionut", new Diagnostic(1,"raceala"), programari_pacient1,new Asigurare(23,"stat","CASMB","10 10 23"));

//        System.out.println("Pacientul1 are asigurare de la " + pacient1.getAsigurare().getTipAsigurare());



        //


        // Initializare servicii

        PacientService pacientService = PacientService.getInstance();
        DoctorService doctorService = DoctorService.getInstance();
        AsigurareService asigurareService = AsigurareService.getInstance();
        RoomService roomService = RoomService.getInstance();
        TriajService triajService = TriajService.getInstance();
        DiagnosticService diagnosticService = DiagnosticService.getInstance();
        CabinetService cabinetService = CabinetService.getInstance();

        //Apelam metode din servicii

//        System.out.println(pacientService.showPacientInfo(pacient1));

//        System.out.println(pacientService.showProgramari(pacient1));

//        System.out.println("Inainte de modificare din serviciu -> nume:" + doctorService.getNume(doc1));

        doctorService.changeName(doc1,"Catalin");

//        System.out.println("Dupa modificarea din serviciu -> nume:" + doctorService.getNume(doc1));


        //ETAPA 2

        //writeDiagnostic();
        List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
        diagnostics.add(new Diagnostic(2,"tuse naspa"));
        diagnostics.add(new Diagnostic(0,"covid"));
        diagnosticService.writeDiagnostic(diagnostics);
        List<Diagnostic> diagnostics2 = new ArrayList<Diagnostic>();
        diagnostics2.add(new Diagnostic(4,"asd"));

        //diagnosticService.writeDiagnostic(diagnostics2);
        //diagnosticService.readDiagnostic();

        List<Asigurare> asigurari = new ArrayList<Asigurare>();
        asigurari.add(new Asigurare(1, "stat","CASMB","20-oct-2023"));
        asigurari.add(new Asigurare(2, "stat","CASMB","23-nov-2021"));
        asigurari.add(new Asigurare(3, "privat","societate privata","23-july-2024"));
        asigurari.add(new Asigurare(4, "privat","societate privata","01-june-2022"));

        //asigurareService.writeAsigurari(asigurari);
        //asigurareService.readAsigurari();

        List<Cabinet> cabinete = new ArrayList<Cabinet>();
        cabinete.add(new Cabinet(1,true));
        cabinete.add(new Cabinet(2,true));
        cabinete.add(new Cabinet(3,true));
        cabinete.add(new Cabinet(4,true));
        cabinete.add(new Cabinet(5,false));

        //cabinetService.writeCabinete(cabinete);
        //cabinetService.readCabinete();

        List<Triaj> triaje = new ArrayList<Triaj>();
        triaje.add(new Triaj(1,"Popescu"));
        triaje.add(new Triaj(2,"Ionescu"));
        triaje.add(new Triaj(3,"Cornel"));
        triaje.add(new Triaj(4,"Ioana"));
        //triajService.writeTriaj(triaje);
//        triajService.readTriaj();



        // ETAPA 3

        AsigurareRepository asigurareRepository = AsigurareRepository.getInstance();
        DiagnosticRepository diagnosticRepository = DiagnosticRepository.getInstance();
//        asigurareRepository.createTable();
//        asigurareRepository.addAsigurare(asigurari.get(0));
//        asigurareRepository.addAsigurare(asigurari.get(1));
//        asigurareRepository.displayAsigurareById(2);
//        asigurareRepository.displayAsigurari();

//        asigurareRepository.updateAsigurareTip("privat",3);
//        asigurareRepository.updateAsigurareTip("Regina Maria",3);
//        asigurareRepository.updateAsigurareDataExpirare("23-march-2024", 3);
//        asigurareRepository.displayAsigurareById(3);


        //diagnosticRepository.createTable();
        //diagnosticRepository.addDiagnostic(diagnostics.get(0));
        //diagnosticRepository.addDiagnostic(diagnostics.get(1));
        //diagnosticRepository.addDiagnostic(diagnostics.get(2));
        diagnosticRepository.updateDiagnostic("picior rupt",1);
        diagnosticRepository.updateDiagnostic("umar luxat", 1);
        diagnosticRepository.displayDiagnosticById(1);
        diagnosticRepository.displayDiagnostics();

    }
}
