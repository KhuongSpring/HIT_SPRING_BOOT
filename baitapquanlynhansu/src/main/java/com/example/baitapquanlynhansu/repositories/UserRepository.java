package com.example.baitapquanlynhansu.repositories;

import com.example.baitapquanlynhansu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUsersByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
