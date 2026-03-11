package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.dto.PatientTimelineDTO;
import com.example.crud_hospital_pt2.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findLogByPatient_IdOrderByDateTime(Long patientId);

    @Query("SELECT new com.example.crud_hospital_pt2.dto.PatientTimelineDTO(" +
            "l.patient.name, " +
            "l.bed.room.ward.specialty, " +
            "l.dateTime, " +
            "(SELECT l2.dateTime FROM Log l2 WHERE l2.patient.id = l.patient.id " +
            " AND l2.eventType = 'DISCHARGE' AND l2.dateTime > l.dateTime ORDER BY l2.dateTime ASC LIMIT 1)) " +
            "FROM Log l " +
            "WHERE l.patient.id = :patientId AND l.eventType = 'ADMISSION' " +
            "ORDER BY l.dateTime DESC")
    Page<PatientTimelineDTO> findPatientTimeline(@Param("patientId") Long patientId, Pageable pageable);



}
