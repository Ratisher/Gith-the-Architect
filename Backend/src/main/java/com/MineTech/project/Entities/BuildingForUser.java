package com.MineTech.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BuildingForUser")
public class BuildingForUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Visiting_date")
    private Date visitingDate;
    @ManyToOne
    @JoinColumn(name = "User_idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "Building_idBuilding")
    private Building building;
    @ManyToOne
    @JoinColumn(name = "Status_idStatus")
    private Status status;
}
