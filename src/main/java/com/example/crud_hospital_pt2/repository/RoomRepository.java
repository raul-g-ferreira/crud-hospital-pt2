package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.dto.report.SpecialtyAndRoomCodeDTO;
import com.example.crud_hospital_pt2.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select r from Room r " +
            "join r.beds b " +
            "where b.patient.id = :patientId")
    public Room findRoomByPatientId(@Param("patientId") Long patientId);

    @Query("select new com.example.crud_hospital_pt2.dto.report.SpecialtyAndRoomCodeDTO(" +
            "r.ward.specialty, r.roomCode) " +
            "from Room r " +
            "where r.isFull = false ")
    public List<SpecialtyAndRoomCodeDTO> findNotFullRooms();
}
