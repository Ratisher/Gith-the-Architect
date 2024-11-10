package com.MineTech.project.Controllers;

import com.MineTech.project.Dto.UserDto;
import com.MineTech.project.Services.CRUDservices;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserRestController {
    
    private CRUDservices crudServices;
    
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto user = crudServices.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = crudServices.getAllUsers();
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return ResponseEntity.ok(users);
        }
    }
    
    @GetMapping("/authorization/{telephone}")
    public ResponseEntity<UserDto> getUserByTelephone(@PathVariable("telephone") String telephone) {
        UserDto user = crudServices.getUserByTelephone(telephone);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return ResponseEntity.ok(user);
        }
    }
}
