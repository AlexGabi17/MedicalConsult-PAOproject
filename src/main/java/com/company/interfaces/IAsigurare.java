package com.company.interfaces;

import com.company.entities.Asigurare;

import java.util.List;

public interface IAsigurare {

    public String toString(com.company.entities.Asigurare asigurare);

    public void writeAsigurari(List<Asigurare> productList);
    public List<Asigurare> readAsigurari();
}
