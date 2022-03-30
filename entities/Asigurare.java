package entities;

public class Asigurare {
    private int id;
    private String tipAsigurare;
    private String numeCasaSanatate;
    private String dataExpirare;

    public void setId(int id) {
        this.id = id;
    }

    public void setTipAsigurare(String tipAsigurare) {
        this.tipAsigurare = tipAsigurare;
    }

    public void setNumeCasaSanatate(String numeCasaSanatate) {
        this.numeCasaSanatate = numeCasaSanatate;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public int getId() {
        return id;
    }

    public String getTipAsigurare() {
        return tipAsigurare;
    }

    public String getNumeCasaSanatate() {
        return numeCasaSanatate;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public Asigurare(int id, String tipAsigurare, String numeCasaSanatate, String dataExpirare) {
        this.id = id;
        this.tipAsigurare = tipAsigurare;
        this.numeCasaSanatate = numeCasaSanatate;
        this.dataExpirare = dataExpirare;
    }

}
