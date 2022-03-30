package entities;

public class Pacient {
    private int id;
    private String nume;

    private Diagnostic diagnostic;

    public void setProgramari(Programare[] programari) {
        this.programari = programari;
    }

    public Programare[] getProgramari() {
        return programari;
    }

    public Pacient(int id, String nume, Diagnostic diagnostic, Programare[] programari, Asigurare asigurare) {
        this.id = id;
        this.nume = nume;
        this.diagnostic = diagnostic;
        this.programari = programari;
        this.asigurare = asigurare;
    }

    private Programare[] programari;
    private Asigurare asigurare;





    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setAsigurare(Asigurare asigurare) {
        this.asigurare = asigurare;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public int getId() {
        return id;
    }


    public Asigurare getAsigurare() {
        return asigurare;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }



}
