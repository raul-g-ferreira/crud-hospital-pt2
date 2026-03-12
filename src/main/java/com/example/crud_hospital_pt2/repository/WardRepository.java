package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.dto.WardOverviewDTO;
import com.example.crud_hospital_pt2.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Long> {

    @Query("select new com.example.crud_hospital_pt2.dto.WardOverviewDTO(" +
            "w.specialty," +
            "cast(sum(case when b.status = 'OCCUPIED' then 1 else 0 end)as integer)," +
            "cast(sum(case when b.status = 'IN_PREPARATION' then 1 else 0 end)as integer)," +
            "cast(sum(case when b.status = 'UNOCCUPIED' then 1 else 0 end)as integer))" +
            "from Ward w " +
            "left join w.rooms r " +
            "left join r.beds b " +
            "where w.id = :wardId " +
            "group by w.id, w.specialty")
    public WardOverviewDTO getWardOverview(@Param("wardId") Long wardId);

    @Query("select w.id from Ward w " +
            "where w.hospital.id = :hospitalId")
    public List<Long> findAllIds(@Param("hospitalId") Long hospitalId);
}
