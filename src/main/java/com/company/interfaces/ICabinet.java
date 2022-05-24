package com.company.interfaces;

import com.company.entities.Cabinet;

import java.util.List;

public interface ICabinet {
    public String toString(Cabinet cabinet);

    public void writeCabinete(List<Cabinet> productList);
    public List<Cabinet>  readCabinete();
}
