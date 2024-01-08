package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Room;
import io.swagger.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room getRoom(Integer roomId) throws NotFoundException {
        Optional<Room> room = roomRepository.findById(roomId);
        if(room.isPresent()){
            return room.get();
        }
        else{
            throw new NotFoundException(404,"Room not found");
        }
    }

    public List<Room> getRooms() throws NotFoundException {
        List<Room> rooms = roomRepository.findAll();
        if(!rooms.isEmpty()){
            return rooms;
        }
        else{
            throw new NotFoundException(404,"Rooms not found");
        }
    }
}
