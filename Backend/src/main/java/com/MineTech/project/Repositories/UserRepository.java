package com.MineTech.project.Repositories;

import com.MineTech.project.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.telephone = :telephone")
    User getUserByTelephone(@Param("telephone") String telephone);
}
