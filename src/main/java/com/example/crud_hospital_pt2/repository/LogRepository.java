package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
