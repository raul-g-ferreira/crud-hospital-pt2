package com.example.crud_hospital_pt2.controller;


import com.example.crud_hospital_pt2.dto.RoomDTO;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create/{wardId}")
    public ResponseEntity<Room> create(@PathVariable Long wardId, @RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(this.roomService.create(wardId, roomDTO));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Room>> getAll() {
        return ResponseEntity.ok(roomService.getAll());
    }
}
