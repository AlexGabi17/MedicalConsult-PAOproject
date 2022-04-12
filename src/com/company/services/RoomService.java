package com.company.services;

import com.company.entities.Room;
import com.company.interfaces.RoomInterface;

public class RoomService implements RoomInterface {
    @Override
    public int getNumber(Room obj) {
        return obj.getNumber();
    }
}
