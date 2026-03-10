package com.example.crud_hospital_pt2.controller;


import com.example.crud_hospital_pt2.model.Patient;
import com.example.crud_hospital_pt2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<Patient> create(@RequestBody Patient patient) {
        return this.patientService.create(patient);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.patientService.deleteById(id);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Patient>> getAll() {
        return this.patientService.getAll();
    }
}
