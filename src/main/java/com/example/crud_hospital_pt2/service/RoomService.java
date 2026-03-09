package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoomService {

    @Autowired
    private BedService bedService;

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public ArrayList<Room> generateRooms(Ward ward, WardDTO dto) {
        ArrayList<Room> roomList = new ArrayList<>();

        for (int i = 1; i <= dto.getRoomQuantity() ; i++) {
            // chamar a geração de roomCode

            Room newRoom = new Room(ward, Boolean.FALSE, roomCode);

            newRoom.setBeds(bedService.generateBeds(newRoom, numberOfBeds));

        }

    }
}
