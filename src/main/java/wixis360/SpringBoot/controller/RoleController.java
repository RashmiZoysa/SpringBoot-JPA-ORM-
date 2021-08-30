package wixis360.SpringBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import wixis360.SpringBoot.service.RoleService;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@RequestMapping("/api")
@Controller
public class RoleController {

    @Autowired
    RoleService roleService;


//    @PostMapping(path= "/save")
//    public ResponseEntity saveCustomer(@RequestBody RoleDto dto) {
//        if (dto.getRID().trim().length() <= 0) {
//            throw new NotFoundException("Customer id cannot be empty");
//        }
//        roleService.addRole(dto);
//        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
//
//    }


}
