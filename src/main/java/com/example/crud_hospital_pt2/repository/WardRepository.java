package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward, Long> {
}
