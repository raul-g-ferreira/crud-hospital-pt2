package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.dto.report.BedTimelineDTO;
import com.example.crud_hospital_pt2.dto.report.PatientInternmentDetailsDTO;
import com.example.crud_hospital_pt2.dto.report.PatientTimelineDTO;
import com.example.crud_hospital_pt2.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findLogByPatient_IdOrderByTimestamp(Long patientId);

    @Query("SELECT new com.example.crud_hospital_pt2.dto.report.PatientTimelineDTO(" +
            "l.patient.name, " +
            "l.bed.room.ward.specialty, " +
            "l.timestamp, " +
            "(SELECT l2.timestamp FROM Log l2 WHERE l2.patient.id = l.patient.id " +
            " AND l2.eventType = 'DISCHARGE' AND l2.timestamp > l.timestamp ORDER BY l2.timestamp ASC LIMIT 1)) " +
            "FROM Log l " +
            "WHERE l.patient.id = :patientId AND l.eventType = 'ADMISSION' " +
            "ORDER BY l.timestamp DESC")
    Page<PatientTimelineDTO> findPatientTimeline(@Param("patientId") Long patientId, Pageable pageable);


    @Query("select new com.example.crud_hospital_pt2.dto.report.BedTimelineDTO(" +
            "l.bed.bedNumber, " +
            "l.patient.name, " +
            "l.timestamp," +
            "(select  l2.timestamp from Log l2 where l2.patient.id = l.patient.id " +
            " and l2.eventType = 'DISCHARGE' and l2.timestamp > l.timestamp order by l2.timestamp asc limit 1))" +
            "from Log l " +
            "where l.bed.id = :bedId and l.eventType = 'ADMISSION' " +
            "order by l.timestamp desc ")
    List<BedTimelineDTO> findBedTimeline(@Param("bedId") Long bedId);

    @Query("select new com.example.crud_hospital_pt2.dto.report.PatientInternmentDetailsDTO(" +
            "l.patient.name, l.bed.room.ward.specialty, l.timestamp)" +
            "from Log l " +
            "where l.eventType = 'ADMISSION' " +
            "and not exists " +
            "(select l2.timestamp from Log l2 where l2.patient.id = l.patient.id and l2.eventType = 'DISCHARGE' and l2.timestamp > l.timestamp order by l2.timestamp asc limit 1) " +
            "order by l.timestamp desc")
    List<PatientInternmentDetailsDTO> findAllInternmentDetails();


}
