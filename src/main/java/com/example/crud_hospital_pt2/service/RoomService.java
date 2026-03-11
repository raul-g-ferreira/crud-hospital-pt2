package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.RoomDTO;
import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.model.Bed;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.RoomRepository;
import com.example.crud_hospital_pt2.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private BedService bedService;

    private final WardRepository wardRepository;
    private final RoomRepository roomRepository;

    public RoomService(WardRepository wardRepository, RoomRepository roomRepository) {
        this.wardRepository = wardRepository;
        this.roomRepository = roomRepository;
    }

    public List<Room> generateRooms(Ward ward, WardDTO dto) {
        List<Room> roomList = ward.getRooms() == null? new ArrayList<>() : ward.getRooms();

        for (int i = 1; i <= dto.getRoomQuantity() ; i++) {
            // chamar a geração de roomCode
            String roomCode = generateRoomCode(ward, roomList);

            Room newRoom = new Room(ward, Boolean.FALSE, roomCode);

            newRoom.setBeds(bedService.generateBeds(newRoom, dto.getBedsPerRoom()));
            roomList.add(newRoom);
        }
        return roomList;
    }

    public Room create(Long wardId, RoomDTO roomDTO) {
        Ward ward = this.wardRepository.findById(wardId).orElseThrow();

        WardDTO wardDTO = new WardDTO(ward.getSpecialty().toString(), 1, roomDTO.getNumberOfBeds());

        List<Room> rooms = generateRooms(ward, wardDTO);

        return roomRepository.save(rooms.getLast());
    }

    public String generateRoomCode(Ward ward, List<Room> roomList) {
        String code = "";
        code += ward.getSpecialty().toString().substring(0,3).toUpperCase();
        code += "-";
        code += (roomList.size() + 1);

        return code;
    }

    public void setRoomFull(Bed bed) {
        Room room = bed.getRoom();
        room.setIsFull(room.getBeds().stream().allMatch(b -> b.getPatient() != null));
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
