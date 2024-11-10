package com.MineTech.project.Repositories;

import com.MineTech.project.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    
}
