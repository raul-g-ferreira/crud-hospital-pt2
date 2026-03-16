package com.example.crud_hospital_pt2.controller;

import com.example.crud_hospital_pt2.dto.report.*;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/free-beds") // Criar requisição para mostrar leitos livres por especialidade
    public ResponseEntity<List<BedReportDTO>> findFreeBedsOrderedBySpecialty() {
        return ResponseEntity.ok(this.reportService.findFreeBedsOrderedBySpecialty());
    }

    @GetMapping("/room-by-patient/{patientId}") // Criar requisição para mostrar o quarto em que o paciente está internado
    public ResponseEntity<Room> findRoomByPatientId(@PathVariable Long patientId){
        return ResponseEntity.ok(this.reportService.findRoomByPatientId(patientId));
    }

    @GetMapping("/all-beds") // Criar requisição para mostrar todos os leitos
    public ResponseEntity<List<AllBedsReportDTO>> findAllBeds() {
        return ResponseEntity.ok(this.reportService.findAllBeds());
    }

    @GetMapping("/hospital-overview/{hospitalId}") // Criar requisição para mostrar a quantidade de quartos livres, ocupados e total por especialidade
    public ResponseEntity<HospitalOverviewDTO> getHospitalOverview(@PathVariable Long hospitalId) {
        return ResponseEntity.ok(this.reportService.hospitalOverview(hospitalId));
    }

    @GetMapping("/internment-det/{patientId}") // Criar requisição que retorne pelo id do paciente que está internado
    public ResponseEntity<PatientInternmentLocationDTO> getInternmentDetails(@PathVariable Long patientId) {
        return ResponseEntity.ok(reportService.findPatientInternmentLocation(patientId));
    }

    @GetMapping("/patient-timeline/{patientId}") // Criar requisição paginada que retorne o histórico de internamento de um paciente
    public ResponseEntity<Page<PatientTimelineDTO>> getPatientTimeline(@PathVariable Long patientId, Pageable pageable) {
        return ResponseEntity.ok(this.reportService.findPatientTimeline(patientId, pageable));
    }

    @GetMapping("/room-not-full") // Criar requisição que retorne lista de quartos com algum leito disponível
    public ResponseEntity<List<SpecialtyAndRoomCodeDTO>> findNotFullRooms() {
        return ResponseEntity.ok(this.reportService.findNotFullRooms());
    }

    @GetMapping("/all-hospitalized") // Criar requisição que retorne lista de todos os pacientes internados no momento, ordenados alfabeticamente e agrupados por especialidade
    public ResponseEntity<List<PatientInternmentDetailsDTO>> getAllInternmentDetails() {
        return ResponseEntity.ok(this.reportService.findAllInternmentDetails());
    }

    @GetMapping("/bed-timeline/{bedId}") // Criar requisição que retorne histórico de internação de um leito específico
    public ResponseEntity<List<BedTimelineDTO>> getBedTimeline(@PathVariable Long bedId) {
        return ResponseEntity.ok(this.reportService.findBedTimeline(bedId));
    }
}
