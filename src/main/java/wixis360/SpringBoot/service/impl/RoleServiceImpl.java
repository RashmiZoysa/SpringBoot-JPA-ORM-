package wixis360.SpringBoot.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wixis360.SpringBoot.dto.RoleDto;
import wixis360.SpringBoot.repo.RoleRepo;
import wixis360.SpringBoot.service.RoleService;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public boolean addRole(RoleDto dto) {
//        if (roleRepo.existsById(dto.getRID())) {
//            throw new ValidateException("Role Already Exists!");
//        }
//        roleRepo.save(mapper.map(dto, Role.class));
        return true ;
    }

    @Override
    public RoleDto searchRole(String rid) {
        return null;
    }

    @Override
    public boolean updateRole(RoleDto dto) {
        return false;
    }

    @Override
    public boolean deleteRole(String rid) {
        return false;
    }

    @Override
    public ArrayList<RoleDto> getAllRoles() {
        return null;
    }
}
