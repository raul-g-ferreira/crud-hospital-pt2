package com.example.crud_hospital_pt2.controller;

import com.example.crud_hospital_pt2.dto.*;
import com.example.crud_hospital_pt2.model.Bed;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/free-beds")
    public ResponseEntity<List<BedReportDTO>> findFreeBedsOrderedBySpecialty() {
        return ResponseEntity.ok(this.reportService.findFreeBedsOrderedBySpecialty());
    }

    @GetMapping("/room-by-patient/{patientId}")
    public ResponseEntity<Room> findRoomByPatientId(@PathVariable Long patientId){
        return ResponseEntity.ok(this.reportService.findRoomByPatientId(patientId));
    }

    @GetMapping("/all-beds")
    public ResponseEntity<List<AllBedsReportDTO>> findAllBeds() {
        return ResponseEntity.ok(this.reportService.findAllBeds());
    }

    @GetMapping("/hospital-overview/{hospitalId}")
    public ResponseEntity<HospitalOverviewDTO> getHospitalOverview(@PathVariable Long hospitalId) {
        return ResponseEntity.ok(this.reportService.hospitalOverview(hospitalId));
    }

    @GetMapping("/internment-det/{patientId}")
    public ResponseEntity<PatientInternmentDetailsDTO> getInternmentDetails(@PathVariable Long patientId) {
        return ResponseEntity.ok(reportService.findPatientInternmentDetails(patientId));
    }

    @GetMapping("/room-not-full")
    public ResponseEntity<List<SpecialtyAndRoomCodeDTO>> findNotFullRooms() {
        return ResponseEntity.ok(this.reportService.findNotFullRooms());
    }

    @GetMapping("/patient-timeline/{patientId}")
    public ResponseEntity<Page<PatientTimelineDTO>> getTimeline(@PathVariable Long patientId, Pageable pageable) {
        return ResponseEntity.ok(this.reportService.getPatientTimeline(patientId, pageable));
    }
}
