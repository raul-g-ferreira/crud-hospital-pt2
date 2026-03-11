package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.*;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ReportService {

 private final HospitalRepository hospitalRepository;
 private final WardRepository wardRepository;
 private final RoomRepository roomRepository;
 private final BedRepository bedRepository;
 private final PatientRepository patientRepository;
 private final LogRepository logRepository;

    public ReportService(HospitalRepository hospitalRepository, WardRepository wardRepository, RoomRepository roomRepository, BedRepository bedRepository, PatientRepository patientRepository, LogRepository logRepository) {
        this.hospitalRepository = hospitalRepository;
        this.wardRepository = wardRepository;
        this.roomRepository = roomRepository;
        this.bedRepository = bedRepository;
        this.patientRepository = patientRepository;
        this.logRepository = logRepository;
    }

    public List<BedReportDTO> findFreeBedsOrderedBySpecialty() {
        return bedRepository.findFreeBedsOrderedBySpecialty();
    }

    public Room findRoomByPatientId(Long patientId) {
        return roomRepository.findRoomByPatientId(patientId);
    }

    public List<AllBedsReportDTO> findAllBeds() {
        return bedRepository.findAllBeds();
    }

    public HospitalOverviewDTO hospitalOverview(Long hospitalId) {
        HospitalOverviewDTO report = hospitalRepository.getHospitalBaseOverview(hospitalId);

        List<Long> wardIds = wardRepository.findAllIds(hospitalId);

        List <WardOverviewDTO> wardReports = wardIds.stream()
                .map(id -> wardRepository.getWardOverview(id))
                .toList();

        report.setWardOverviewDTOS(wardReports);

        return report;
    }

    public PatientInternmentDetailsDTO findPatientInternmentDetails(Long patientId) {
        PatientInternmentDetailsDTO report = patientRepository.findPatientInternmentDetails(patientId);

        report.setInternmentDate(logRepository.findLogByPatient_IdOrderByDateTime(patientId).getFirst().getDateTime());

        return report;
    }

    public List<SpecialtyAndRoomCodeDTO> findNotFullRooms() {
        return roomRepository.findNotFullRooms();
    }

    public Page<PatientTimelineDTO> getPatientTimeline(Long patientId, Pageable pageable) {
        return logRepository.findPatientTimeline(patientId, pageable);
    }

}
