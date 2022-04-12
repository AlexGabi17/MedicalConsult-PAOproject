package com.company.services;

import com.company.interfaces.Room;

public class RoomService implements Room {
    @Override
    public int getNumber(com.company.entities.Room obj) {
        return obj.getNumber();
    }
}
