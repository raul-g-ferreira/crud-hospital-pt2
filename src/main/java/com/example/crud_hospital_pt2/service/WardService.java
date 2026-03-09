package com.example.crud_hospital_pt2.service;

import com.example.crud_hospital_pt2.dto.WardDTO;
import com.example.crud_hospital_pt2.model.Hospital;
import com.example.crud_hospital_pt2.model.Room;
import com.example.crud_hospital_pt2.model.Ward;
import com.example.crud_hospital_pt2.repository.WardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WardService {

    @Autowired
    private RoomService roomService;

    private final WardRepository wardRepository;

    public WardService(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }


    public ArrayList<Ward> generateWards(Hospital hospital, ArrayList<WardDTO> wardDTOS) {
        ArrayList<Ward> wardList = new ArrayList<>();

        for (WardDTO dto : wardDTOS) {
            Ward newWard = new Ward(dto.getSpecialty(), hospital);

            newWard.setRooms(roomService.generateRooms(newWard, dto));

            wardList.add(newWard);
        }

        return wardList;
    }

}
