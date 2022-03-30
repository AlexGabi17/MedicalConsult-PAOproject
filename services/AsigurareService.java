package services;

import entities.Asigurare;
import interfaces.AsigurareInterface;

public class AsigurareService implements AsigurareInterface {
    @Override
    public int getId(Asigurare obj) {
        return obj.getId();
    }

    @Override
    public String getTipAsigurare(Asigurare obj) {
        return obj.getTipAsigurare();
    }

    @Override
    public String getNumeCasaSanatate(Asigurare obj) {
        return obj.getNumeCasaSanatate();
    }

    @Override
    public String getDataExpirare(Asigurare obj) {
        return obj.getDataExpirare();
    }

    @Override
    public void changeTipAsigurare(Asigurare obj, String tip) {
        obj.setTipAsigurare(tip);
    }

    @Override
    public void changeNumeCasaSanatate(Asigurare obj, String casa){
        obj.setNumeCasaSanatate(casa);
    }

    @Override
    public void changeDataExpirare(Asigurare obj, String dataExpirare){
        obj.setDataExpirare(dataExpirare);
    }
}
