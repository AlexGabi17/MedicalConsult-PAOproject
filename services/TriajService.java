package services;

import entities.Triaj;
import interfaces.TriajInterface;

public class TriajService implements TriajInterface {

    @Override
    public String getSefTriaj(Triaj obj) {
        return obj.getSefTriaj();
    }
}
