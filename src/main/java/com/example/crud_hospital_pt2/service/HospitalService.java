package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.HospitalDTO;
import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.exception.HospitalNotFoundException;
import com.example.crud_hospital_pt2.model.Hospital;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private WardService wardService;

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public ResponseEntity<Hospital> create(@RequestBody HospitalDTO hospitalDTO) {
        Hospital newHospital = new Hospital(hospitalDTO.getHospitalName(), hospitalDTO.getHospitalPhone(), hospitalDTO.getHospitalCnpj());


        List<Ward> wardList = wardService.generateWards(newHospital, hospitalDTO.getWardDTOs());

        newHospital.setWards(wardList);
        return ResponseEntity.ok(hospitalRepository.save(newHospital));
    }

    public Hospital findById(Long id) {
        return hospitalRepository.findById(id).orElseThrow(() -> new HospitalNotFoundException("Could not find hospital with id: "+ id));
    }

    public ResponseEntity<List<Hospital>> getAll() {
        return ResponseEntity.ok(hospitalRepository.findAll());
    }
}
