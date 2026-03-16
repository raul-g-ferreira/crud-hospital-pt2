package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.dto.report.AllBedsReportDTO;
import com.example.crud_hospital_pt2.dto.report.BedReportDTO;
import com.example.crud_hospital_pt2.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, Long> {

    @Query("select new com.example.crud_hospital_pt2.dto.report.BedReportDTO(" +
            "b.id, b.room.roomCode, b.bedNumber) " +
            "from Bed b " +
            "where b.status = 'UNOCCUPIED' " +
            "order by b.room.roomCode asc, b.bedNumber asc ")
    public List<BedReportDTO> findFreeBedsOrderedBySpecialty();


    @Query("select new com.example.crud_hospital_pt2.dto.report.AllBedsReportDTO(" +
            "b.id, b.room.roomCode, b.bedNumber, b.status)" +
            " from Bed b " +
            "order by b.room.roomCode, b.bedNumber")
    public List<AllBedsReportDTO> findAllBeds();
}
