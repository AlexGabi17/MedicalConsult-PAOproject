package com.company.services;

import com.company.interfaces.Triaj;

public class TriajService implements Triaj {

    @Override
    public String getSefTriaj(com.company.entities.Triaj obj) {
        return obj.getSefTriaj();
    }
}
