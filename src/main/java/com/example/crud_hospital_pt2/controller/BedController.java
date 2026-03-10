package com.example.crud_hospital_pt2.controller;

import com.example.crud_hospital_pt2.dto.BedDTO;
import com.example.crud_hospital_pt2.model.Bed;
import com.example.crud_hospital_pt2.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bed")
public class BedController {

    @Autowired
    private BedService bedService;

    @PostMapping("/create")
    public ResponseEntity<Bed> create(@RequestBody BedDTO bedDTO) {
        return this.bedService.create(bedDTO);
    }
}
