package com.MineTech.project.Mappers;

import com.MineTech.project.Dto.UserDto;
import com.MineTech.project.Entities.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
            user.getIdUser(),
            user.getFirstName(),
            user.getSecondName(),
            user.getTelephone()
        );
    }
    public static User mapToUser(UserDto userDto) {
        return new User(
            userDto.getIdUser(),
            userDto.getFirstName(),
            userDto.getSecondName(),
            userDto.getTelephone()
        );
    }    
}
