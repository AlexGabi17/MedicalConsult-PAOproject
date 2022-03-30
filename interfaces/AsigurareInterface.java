package interfaces;

import entities.Asigurare;

public interface AsigurareInterface {
    public int getId(Asigurare obj);
    public String getTipAsigurare(Asigurare obj);
    public String getNumeCasaSanatate(Asigurare obj);
    public String getDataExpirare(Asigurare obj);

    public void changeTipAsigurare(Asigurare obj, String tip);
    public void changeNumeCasaSanatate(Asigurare obj, String casa);
    public void changeDataExpirare(Asigurare obj,String dataExpirare);
}
