package com.example.crud_hospital_pt2.controller;

import com.example.crud_hospital_pt2.dto.HospitalDTO;
import com.example.crud_hospital_pt2.model.Hospital;
import com.example.crud_hospital_pt2.repository.HospitalRepository;
import com.example.crud_hospital_pt2.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/create")
    public ResponseEntity<Hospital> create(@RequestBody HospitalDTO hospitalDto) {
        return ResponseEntity.ok(hospitalService.create(hospitalDto).getBody());
    }

}