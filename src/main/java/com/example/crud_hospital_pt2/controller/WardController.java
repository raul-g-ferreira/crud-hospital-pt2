package com.example.crud_hospital_pt2.controller;

import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ward")
public class WardController {

    @Autowired
    private WardService wardService;

    @PostMapping("/create/{hospitalId}")
    public ResponseEntity<Ward> create(@PathVariable Long hospitalId, @RequestBody WardDTO wardDTO) {
        return this.wardService.create(hospitalId, wardDTO);
    }
}