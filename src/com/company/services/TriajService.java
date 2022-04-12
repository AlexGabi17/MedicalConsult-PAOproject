package com.company.services;

import com.company.entities.Triaj;
import com.company.interfaces.TriajInterface;

public class TriajService implements TriajInterface {

    @Override
    public String getSefTriaj(Triaj obj) {
        return obj.getSefTriaj();
    }
}
