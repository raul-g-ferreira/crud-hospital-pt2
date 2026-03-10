package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.HospitalDTO;
import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.model.Hospital;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

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


        ArrayList<Ward> wardList = wardService.generateWards(newHospital, hospitalDTO.getWardDTOs());

        newHospital.setWards(wardList);
        return ResponseEntity.ok(hospitalRepository.save(newHospital));
    }


    public Hospital findById(Long id) {
        return hospitalRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
