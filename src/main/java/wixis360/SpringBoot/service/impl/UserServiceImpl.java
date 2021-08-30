package wixis360.SpringBoot.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wixis360.SpringBoot.dto.UserDto;
import wixis360.SpringBoot.entity.User;
import wixis360.SpringBoot.exception.ValidateException;
import wixis360.SpringBoot.repo.UserRepo;
import wixis360.SpringBoot.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addUser(UserDto dto) {
        if (userRepo.existsById(dto.getUID())) {
            throw new ValidateException("User Already Exists...");
        }
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public UserDto searchUser(String uid) {
            Optional<User> user = userRepo.findById(uid);
            if (user.isPresent()) {
                return mapper.map(user.get(), UserDto.class);
            }
            return null;

          }

    @Override
    public void updateUser(UserDto dto) {
        if (userRepo.existsById(dto.getUID())) {
            userRepo.save(mapper.map(dto, User.class));

        }
    }

    @Override
    public boolean deleteUser(String uid) {
        if (!userRepo.existsById(uid)) {
            throw new ValidateException("No User for Delete..!");
        }
        userRepo.deleteById(uid);
        return true;
    }

    @Override
    public ArrayList<UserDto> getAllUsers() {
        List<User> all = userRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<UserDto>>() {
        }.getType());   }
}
