package com.company.entities;

public class Cabinet extends Room{
    private Boolean hasBed;
    public Cabinet(int number, Boolean hasBed) {
        super(number);
        this.hasBed = hasBed;
    }
    public void setHasBed(Boolean hasBed) {
        this.hasBed = hasBed;
    }

    public Boolean getHasBed() {
        return hasBed;
    }

}
