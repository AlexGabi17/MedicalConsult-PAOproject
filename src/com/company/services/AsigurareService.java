package com.company.services;

import com.company.interfaces.Asigurare;

public class AsigurareService implements Asigurare {
    @Override
    public int getId(com.company.entities.Asigurare obj) {
        return obj.getId();
    }

    @Override
    public String getTipAsigurare(com.company.entities.Asigurare obj) {
        return obj.getTipAsigurare();
    }

    @Override
    public String getNumeCasaSanatate(com.company.entities.Asigurare obj) {
        return obj.getNumeCasaSanatate();
    }

    @Override
    public String getDataExpirare(com.company.entities.Asigurare obj) {
        return obj.getDataExpirare();
    }

    @Override
    public void changeTipAsigurare(com.company.entities.Asigurare obj, String tip) {
        obj.setTipAsigurare(tip);
    }

    @Override
    public void changeNumeCasaSanatate(com.company.entities.Asigurare obj, String casa){
        obj.setNumeCasaSanatate(casa);
    }

    @Override
    public void changeDataExpirare(com.company.entities.Asigurare obj, String dataExpirare){
        obj.setDataExpirare(dataExpirare);
    }
}
