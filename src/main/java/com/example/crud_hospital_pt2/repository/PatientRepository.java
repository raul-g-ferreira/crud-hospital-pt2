package com.example.crud_hospital_pt2.repository;

import com.example.crud_hospital_pt2.dto.PatientInternmentDetailsDTO;
import com.example.crud_hospital_pt2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select  new com.example.crud_hospital_pt2.dto.PatientInternmentDetailsDTO(" +
            "b.room.ward.hospital.name, b.room.ward.specialty, b.room.roomCode, p.name)" +
            "from Patient p " +
            "left join Bed b on b.patient = p " +
            "where p.id = :patientId")
    public PatientInternmentDetailsDTO findPatientInternmentDetails(@Param("patientId") Long patientId);
}
