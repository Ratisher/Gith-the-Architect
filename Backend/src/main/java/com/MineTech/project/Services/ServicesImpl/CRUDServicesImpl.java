package com.MineTech.project.Services.ServicesImpl;

import com.MineTech.project.Dto.UserDto;
import com.MineTech.project.Entities.User;
import com.MineTech.project.Mappers.UserMapper;
import com.MineTech.project.Repositories.UserRepository;
import com.MineTech.project.Services.CRUDservices;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CRUDServicesImpl implements CRUDservices {
    
    public UserRepository userRepository;
    
    @Override
    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User addedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(addedUser);
    }
    
    @Override
    public UserDto getUserByTelephone(String telephone) {
        User user = userRepository.getUserByTelephone(telephone);
        return UserMapper.mapToUserDto(user);
    }
    
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
    }
}
