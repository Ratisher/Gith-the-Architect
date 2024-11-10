package com.MineTech.project.Repositories;

import com.MineTech.project.Entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    
}
