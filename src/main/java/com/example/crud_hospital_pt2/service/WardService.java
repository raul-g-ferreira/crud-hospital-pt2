package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.model.Hospital;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.model.Specialty;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.WardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WardService {

    @Autowired
    private RoomService roomService;

    @Autowired
    private HospitalService hospitalService;

    private final WardRepository wardRepository;

    public WardService(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    public ResponseEntity<Ward> create(Long hospitalId, WardDTO wardDTO) {
        Hospital hospital = this.hospitalService.findById(hospitalId);
        ArrayList<WardDTO> wardDTOS = new ArrayList<>();
        wardDTOS.add(wardDTO);
        ArrayList<Ward> wards = generateWards(hospital, wardDTOS);

        return ResponseEntity.ok(wardRepository.save(wards.getFirst()));
    }


    public ArrayList<Ward> generateWards(Hospital hospital, ArrayList<WardDTO> wardDTOS) {
        ArrayList<Ward> wardList = new ArrayList<>();

        for (WardDTO dto : wardDTOS) {
            Ward newWard = new Ward(Specialty.valueOf(dto.getSpecialty().toUpperCase()), hospital);

            newWard.setRooms(roomService.generateRooms(newWard, dto));

            wardList.add(newWard);
        }

        return wardList;
    }

    public Ward findById(Long id) {
        return wardRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
