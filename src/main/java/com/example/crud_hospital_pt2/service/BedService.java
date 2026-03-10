package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.BedDTO;
import com.example.crud_hospital_pt2.dto.RoomDTO;
import com.example.crud_hospital_pt2.model.Bed;
import com.example.crud_hospital_pt2.model.BedStatus;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.repository.BedRepository;
import com.example.crud_hospital_pt2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BedService {

    private final RoomRepository roomRepository;
    private final BedRepository bedRepository;

    public BedService(RoomRepository roomRepository, BedRepository bedRepository) {
        this.roomRepository = roomRepository;
        this.bedRepository = bedRepository;
    }

    public ArrayList<Bed> generateBeds(Room room, Integer numberOfBeds) {
        ArrayList<Bed> bedList = new ArrayList<>();

        for (int i = 1; i <= numberOfBeds; i++) {
            Bed newBed = new Bed(BedStatus.UNOCCUPIED, i, room);

            bedList.add(newBed);
        }

        return bedList;
    }

    public ResponseEntity<Bed> create(BedDTO bedDTO) {
        Room room = this.roomRepository.findById(bedDTO.getRoomId()).orElseThrow();
        Integer bedNumber = room.getBeds().size() + 1;
        Bed newBed = new Bed(BedStatus.UNOCCUPIED, bedNumber, room);

        return ResponseEntity.ok(bedRepository.save(newBed));
    }

    public Bed findById(Long id) {
        return bedRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void setBedStatus(Long bedId, BedStatus bedStatus) {
        Bed bed = this.findById(bedId);
        bed.setStatus(bedStatus);
        bedRepository.save(bed);
    }

    public List<Bed> getAll() {
        return bedRepository.findAll();
    }
}
