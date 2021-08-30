package wixis360.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wixis360.SpringBoot.dto.UserDto;
import wixis360.SpringBoot.exception.NotFoundException;
import wixis360.SpringBoot.service.UserService;
import wixis360.SpringBoot.utill.StandardResponse;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    INSERT INTO role(rid,role_name ) VALUES ('R001','Admin');
//    INSERT INTO role(rid,role_name ) VALUES ('R002','Customer');
//    INSERT INTO role(rid,role_name ) VALUES ('R003','User');


    @PostMapping
    @ResponseBody
    public ResponseEntity saveUser(@RequestBody UserDto dto) {
        if (dto.getUid().trim().length() <= 0) {
            throw new NotFoundException("User id cannot be empty");
        }
        userService.addUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.CREATED);

    }

    @GetMapping("/{uid}")
    public UserDto searchUser(@PathVariable String uid) {
        UserDto user = userService.searchUser(uid);
        return user;
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity deleteUser(@PathVariable String uid) {
        boolean done = userService.deleteUser(uid);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDto dto) {
        if (dto.getUid().trim().length() <= 0) {
            throw new RuntimeException("Customer Not Found...");
        }
        userService.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        ArrayList<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity(new StandardResponse("200", "Done", allUsers), HttpStatus.OK);
    }

}