package wixis360.SpringBoot.service;

import wixis360.SpringBoot.dto.RoleDto;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/
public interface RoleService {
    boolean addRole(RoleDto dto);
    RoleDto searchRole(String rid);
    boolean updateRole(RoleDto dto);
    boolean deleteRole(String rid);
    ArrayList<RoleDto> getAllRoles();
}
