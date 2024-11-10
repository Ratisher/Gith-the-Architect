package com.MineTech.project.Services;

import com.MineTech.project.Dto.UserDto;
import java.util.List;

public interface CRUDservices {
    UserDto addUser(UserDto userDto);
    UserDto getUserByTelephone(String telephone);
    List<UserDto> getAllUsers();
}
