package com.company.interfaces;

import com.company.entities.Asigurare;

import java.util.ArrayList;

public interface Cabinet {
    public String toString(com.company.entities.Cabinet cabinet);

    public void writeCabinete(ArrayList<com.company.entities.Cabinet> productList);
    public ArrayList<com.company.entities.Cabinet>  readCabinete();
}
