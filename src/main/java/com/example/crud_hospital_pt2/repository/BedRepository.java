package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepository extends JpaRepository<Bed, Long> {
}
