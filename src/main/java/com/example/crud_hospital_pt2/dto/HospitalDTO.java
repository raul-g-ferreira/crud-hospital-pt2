package com.example.crud_hospital_pt2.dto;


import lombok.Data;

import java.util.ArrayList;

@Data
public class HospitalDTO {

    private String hospitalName;
    private String hospitalPhone;
    private String hospitalCnpj;

    private ArrayList<WardDTO> wardDTOs;


    public HospitalDTO(String hospitalName, String hospitalPhone, String hospitalCnpj) {
        this.hospitalName = hospitalName;
        this.hospitalPhone = hospitalPhone;
        this.hospitalCnpj = hospitalCnpj;
    }

    public HospitalDTO(String hospitalName, String hospitalPhone, String hospitalCnpj, ArrayList<WardDTO> wardDTOs) {
        this.hospitalName = hospitalName;
        this.hospitalPhone = hospitalPhone;
        this.hospitalCnpj = hospitalCnpj;
        this.wardDTOs = wardDTOs;
    }
}
