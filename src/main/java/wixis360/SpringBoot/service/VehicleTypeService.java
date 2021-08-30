package wixis360.SpringBoot.service;

import wixis360.SpringBoot.dto.VehicleTypeDto;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/
public interface VehicleTypeService {
    void addVehicle(VehicleTypeDto dto);
    VehicleTypeDto searchVehicle(String vid);
    void updateVehicle(VehicleTypeDto dto);
    boolean deleteVehicle(String vid);
    ArrayList<VehicleTypeDto> getAllVehicle();
}
