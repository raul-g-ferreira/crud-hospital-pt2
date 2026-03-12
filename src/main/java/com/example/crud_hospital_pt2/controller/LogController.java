package com.example.crud_hospital_pt2.controller;

import com.example.crud_hospital_pt2.dto.LogDTO;
import com.example.crud_hospital_pt2.model.Log;
import com.example.crud_hospital_pt2.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/create")
    public ResponseEntity<Log> create(@RequestBody LogDTO logDTO) {
        return this.logService.create(logDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Log>> getAll() {
        return ResponseEntity.ok(this.logService.getAll());
    }
}
