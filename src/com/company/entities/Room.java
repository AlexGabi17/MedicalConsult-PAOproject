package com.company.entities;

public class Room {
    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Room(int number) {
        this.number = number;
    }

    private int number;
}
