package com.company.interfaces;

import com.company.entities.Triaj;

import java.util.List;

public interface ITriaj {
    public String getSefTriaj(Triaj obj);
    public String toString(Triaj triaj);
    public void writeTriaj(List<Triaj> productList);
    public List<Triaj> readTriaj();
}
