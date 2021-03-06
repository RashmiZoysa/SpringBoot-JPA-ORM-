package wixis360.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wixis360.SpringBoot.dto.VehicleTypeDto;
import wixis360.SpringBoot.exception.NotFoundException;
import wixis360.SpringBoot.service.VehicleTypeService;
import wixis360.SpringBoot.utill.StandardResponse;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

//    INSERT INTO role(vid,type ) VALUES ('R001','Admin');
//    INSERT INTO role(vid,role_name ) VALUES ('R002','Customer');
//    INSERT INTO role(rid,role_name ) VALUES ('R003','User');


@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleTypeController {
    @Autowired
    VehicleTypeService vehicleTypeService;

    @PostMapping
    @ResponseBody
    public ResponseEntity saveUser(@RequestBody VehicleTypeDto dto) {
        if (dto.getVid().trim().length() <= 0) {
            throw new NotFoundException("Vehicle id cannot be empty");
        }
        vehicleTypeService.addVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.CREATED);

    }

    @GetMapping("/{vid}")
    public @ResponseBody VehicleTypeDto searchVehicle(@PathVariable String vid){
        VehicleTypeDto vehicle = vehicleTypeService.searchVehicle(vid);
        return vehicle;
    }

    @DeleteMapping("/{vid}")
    @ResponseBody
    public ResponseEntity deleteVehicle(@PathVariable String vid){
        boolean done = vehicleTypeService.deleteVehicle(vid);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateVehicle(@RequestBody VehicleTypeDto dto){
        if (dto.getVid().trim().length()<=0) {
            throw new RuntimeException("Customer Not Found...");
        }
        vehicleTypeService.updateVehicle(dto);
        return new ResponseEntity(new StandardResponse("200","Done",dto),HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<VehicleTypeDto> getAllVehicles(){
        ArrayList<VehicleTypeDto> allVehicles = vehicleTypeService.getAllVehicle();
        return new ResponseEntity(new StandardResponse("200", "Done", allVehicles), HttpStatus.OK);
    }

}
