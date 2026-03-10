package com.example.crud_hospital_pt2.dto;


import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
