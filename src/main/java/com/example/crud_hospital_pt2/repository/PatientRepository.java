package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
