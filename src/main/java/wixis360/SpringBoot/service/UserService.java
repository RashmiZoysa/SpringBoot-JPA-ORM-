package wixis360.SpringBoot.service;

import wixis360.SpringBoot.dto.UserDto;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/
public interface UserService {
    void addUser(UserDto dto);
    UserDto searchUser(String uid);
    void updateUser(UserDto dto);
    boolean deleteUser(String uid);
    ArrayList<UserDto> getAllUsers();
}
