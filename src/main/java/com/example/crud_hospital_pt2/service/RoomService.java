package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.RoomDTO;
import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoomService {

    @Autowired
    private BedService bedService;
    @Autowired
    private WardService wardService;

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public ArrayList<Room> generateRooms(Ward ward, WardDTO dto) {
        ArrayList<Room> roomList = new ArrayList<>();

        for (int i = 1; i <= dto.getRoomQuantity() ; i++) {
            // chamar a geração de roomCode
            String roomCode = generateRoomCode(ward);

            Room newRoom = new Room(ward, Boolean.FALSE, roomCode);

            newRoom.setBeds(bedService.generateBeds(newRoom, dto.getBedsPerRoom()));
            roomList.add(newRoom);
        }

        return roomList;
    }

    public String generateRoomCode(Ward ward) {
        String code = "";
        code += ward.getSpecialty().toString().substring(0,3).toUpperCase();
        code += "-";
        code += ward.getRooms().size() + 1;

        return code;
    }

    public ResponseEntity<Room> create(Long wardId, RoomDTO roomDTO) {
        Ward ward = this.wardService.findById(wardId);

        WardDTO wardDTO = new WardDTO(ward.getSpecialty().toString(), 1, roomDTO.getNumberOfBeds());

        ArrayList<Room> rooms = generateRooms(ward, wardDTO);

        return ResponseEntity.ok(roomRepository.save(rooms.getFirst()));
    }

    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
