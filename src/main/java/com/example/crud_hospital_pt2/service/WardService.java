package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.exception.WardNotFoundException;
import com.example.crud_hospital_pt2.model.Hospital;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.model.Specialty;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.HospitalRepository;
import com.example.crud_hospital_pt2.repository.WardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WardService {

    @Autowired
    private RoomService roomService;


    private final HospitalRepository hospitalRepository;
    private final WardRepository wardRepository;

    public WardService(HospitalRepository hospitalRepository, WardRepository wardRepository) {
        this.hospitalRepository = hospitalRepository;
        this.wardRepository = wardRepository;
    }

    public ResponseEntity<Ward> create(Long hospitalId, WardDTO wardDTO) {
        Hospital hospital = this.hospitalRepository.findById(hospitalId).orElseThrow(RuntimeException::new);
        ArrayList<WardDTO> wardDTOS = new ArrayList<>();
        wardDTOS.add(wardDTO);
        List<Ward> wards = generateWards(hospital, wardDTOS);

        return ResponseEntity.ok(wardRepository.save(wards.getLast()));
    }


    public List<Ward> generateWards(Hospital hospital, ArrayList<WardDTO> wardDTOS) {
        List<Ward> wardList = hospital.getWards() == null? new ArrayList<>() : hospital.getWards();
        if (wardDTOS.isEmpty()) return wardList;
        for (WardDTO dto : wardDTOS) {
            boolean wardAlreadyExists = wardList.stream().anyMatch(ward -> ward.getSpecialty().name().equals(dto.getSpecialty()));
            if (wardAlreadyExists) throw new IllegalArgumentException("The " + dto.getSpecialty() + " ward already exists");
            Ward newWard = new Ward(Specialty.valueOf(dto.getSpecialty().toUpperCase()), hospital);

            newWard.setRooms(roomService.generateRooms(newWard, dto));

            wardList.add(newWard);
        }

        return wardList;
    }

    public Ward findById(Long id) {
        return wardRepository.findById(id).orElseThrow(() -> new WardNotFoundException("Ward not found, id:" + id));
    }

}
