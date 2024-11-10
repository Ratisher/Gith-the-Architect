package com.MineTech.project.Dto;

import com.MineTech.project.Entities.Building;
import com.MineTech.project.Entities.Status;
import com.MineTech.project.Entities.User;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuildingForUserDto {
    private Long id;
    private Date visitingDate;
    private User user;
    private Building building;
    private Status status;
}
