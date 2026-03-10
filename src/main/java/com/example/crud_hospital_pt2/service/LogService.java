package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.LogDTO;
import com.example.crud_hospital_pt2.model.*;
import com.example.crud_hospital_pt2.repository.BedRepository;
import com.example.crud_hospital_pt2.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private BedService bedService;
    @Autowired
    private PatientService patientService;

    private final LogRepository logRepository;
    private final BedRepository bedRepository;

    public LogService(LogRepository logRepository, BedRepository bedRepository) {
        this.logRepository = logRepository;
        this.bedRepository = bedRepository;
    }

    public List<Log> getAll() {
        return logRepository.findAll();
    }

    public ResponseEntity<Log> create(LogDTO logDTO) {

        Patient patient = this.patientService.findById(logDTO.getPatientId());
        Bed bed = this.bedService.findById(logDTO.getBedId());
        Event eventType = logDTO.getEventType();

        switch (eventType) {
            case ADMISSION:
                validAdmission(patient, bed);
                admission(patient, bed);
                break;
            case DISCHARGE:
                validDischarge(patient, bed);
                discharge(patient, bed);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + logDTO.getEventType());
        }

        Log log = new Log(bed, patient, LocalDateTime.now(), eventType);
        return ResponseEntity.ok(logRepository.save(log));
    }

    private void validAdmission(Patient patient, Bed bed) {
        if (bed.getPatient() != null) throw new IllegalArgumentException("O leito já está ocupado");

        boolean patientInBed = bedRepository.findAll().stream().anyMatch(b -> b.getPatient() != null && b.getPatient().equals(patient));
        if (patientInBed) throw new IllegalArgumentException("O paciente já está internado");
    }

    private void validDischarge(Patient patient, Bed bed) {
        if (bed.getPatient() != patient) throw new IllegalArgumentException("O paciente não se encontra nesse leito");
    }

    public void admission(Patient patient, Bed bed) {
        bed.setPatient(patient);
        bed.setStatus(BedStatus.OCCUPIED);
    }

    public void discharge(Patient patient, Bed bed) {
        bed.setPatient(null);
        bed.setStatus(BedStatus.IN_PREPARATION);
    }
}
