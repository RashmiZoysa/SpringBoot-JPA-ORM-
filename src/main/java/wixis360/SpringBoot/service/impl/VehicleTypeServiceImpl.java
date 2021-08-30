package wixis360.SpringBoot.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wixis360.SpringBoot.dto.VehicleTypeDto;
import wixis360.SpringBoot.entity.VehicleType;
import wixis360.SpringBoot.exception.ValidateException;
import wixis360.SpringBoot.repo.VehicleTypeRepo;
import wixis360.SpringBoot.service.VehicleTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@Service
@Transactional
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    VehicleTypeRepo vehicleTypeRepo;

    @Autowired
    ModelMapper mapper;
    @Override
    public void addVehicle(VehicleTypeDto dto) {
        if (vehicleTypeRepo.existsById(dto.getVID())) {
            throw new ValidateException("User Already Exists...");
        }
        vehicleTypeRepo.save(mapper.map(dto, VehicleType.class));
    }

    @Override
    public VehicleTypeDto searchVehicle(String vid) {
        Optional<VehicleType> vehicleType = vehicleTypeRepo.findById(vid);
        if (vehicleType.isPresent()) {
            return mapper.map(vehicleType.get(), VehicleTypeDto .class);
        }
        return null;    }

    @Override
    public void updateVehicle(VehicleTypeDto dto) {
        if (vehicleTypeRepo.existsById(dto.getVID())) {
            vehicleTypeRepo.save(mapper.map(dto, VehicleType.class));

        }
    }

    @Override
    public boolean deleteVehicle(String vid) {
        if (!vehicleTypeRepo.existsById(vid)) {
            throw new ValidateException("No User for Delete..!");
        }
        vehicleTypeRepo.deleteById(vid)
        ;

        return false;
    }

    @Override
    public ArrayList<VehicleTypeDto> getAllVehicle() {
        List<VehicleType> all = vehicleTypeRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<VehicleTypeDto>>() {
        }.getType());
    }

}
