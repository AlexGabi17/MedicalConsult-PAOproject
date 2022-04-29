package com.company.services;

import com.company.interfaces.Room;

public class RoomService implements Room {
    private static RoomService single_instance = null;

    public static RoomService getInstance()
    {
        if (single_instance == null) {
            single_instance = new RoomService();
        }
        return single_instance;
    }
    @Override
    public int getNumber(com.company.entities.Room obj) {
        return obj.getNumber();
    }
}
