package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
