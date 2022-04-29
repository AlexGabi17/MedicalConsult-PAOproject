package com.company.interfaces;

import com.company.entities.Cabinet;

import java.util.ArrayList;

public interface Triaj{
    public String getSefTriaj(com.company.entities.Triaj obj);
    public String toString(com.company.entities.Triaj triaj);
    public void writeTriaj(ArrayList<com.company.entities.Triaj> productList);
    public ArrayList<com.company.entities.Triaj> readTriaj();
}
