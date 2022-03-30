package services;

import entities.Room;
import interfaces.RoomInterface;

public class RoomService implements RoomInterface {
    @Override
    public int getNumber(Room obj) {
        return obj.getNumber();
    }
}
