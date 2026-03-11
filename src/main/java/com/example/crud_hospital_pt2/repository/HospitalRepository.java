package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.dto.HospitalOverviewDTO;
import com.example.crud_hospital_pt2.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    @Query("SELECT new com.example.crud_hospital_pt2.dto.HospitalOverviewDTO(" +
            "h.name, " +
            "CAST(SUM(CASE WHEN b.status = 'OCCUPIED' THEN 1 ELSE 0 END) AS int), " +
            "CAST(SUM(CASE WHEN b.status = 'IN_PREPARATION' THEN 1 ELSE 0 END) AS int), " +
            "CAST(SUM(CASE WHEN b.status = 'UNOCCUPIED' THEN 1 ELSE 0 END) AS int)) " +
            "FROM Hospital h " +
            "LEFT JOIN h.wards w " +
            "LEFT JOIN w.rooms r " +
            "LEFT JOIN r.beds b " +
            "WHERE h.id = :hospitalId " +
            "group by h.id, h.name")
    HospitalOverviewDTO getHospitalBaseOverview(@Param("hospitalId") Long hospitalId);
}
