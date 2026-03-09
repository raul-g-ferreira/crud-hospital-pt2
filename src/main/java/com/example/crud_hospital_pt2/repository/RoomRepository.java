package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
