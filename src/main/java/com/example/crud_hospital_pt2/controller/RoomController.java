package com.example.crud_hospital_pt2.controller;


import com.example.crud_hospital_pt2.dto.RoomDTO;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create/{wardId}")
    public ResponseEntity<Room> create(@PathVariable Long wardId, @RequestBody RoomDTO roomDTO) {
        return this.roomService.create(wardId, roomDTO);
    }
}
