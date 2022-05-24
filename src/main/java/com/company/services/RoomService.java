package com.company.services;

import com.company.entities.Room;
import com.company.interfaces.IRoom;

public class RoomService implements IRoom {
    private static RoomService single_instance = null;

    private RoomService(){

    }

    public static RoomService getInstance()
    {
        if (single_instance == null) {
            single_instance = new RoomService();
        }
        return single_instance;
    }
    @Override
    public int getNumber(Room obj) {
        return obj.getNumber();
    }
}
