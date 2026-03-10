package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.model.Patient;
import com.example.crud_hospital_pt2.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public ResponseEntity<Patient> create(Patient patient) {
        return ResponseEntity.ok(patientRepository.save(patient));
    }

    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findById(Long id) {
        return this.patientRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
