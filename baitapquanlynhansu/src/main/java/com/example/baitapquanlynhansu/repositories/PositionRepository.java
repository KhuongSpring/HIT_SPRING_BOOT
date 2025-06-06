package com.example.baitapquanlynhansu.repositories;

import com.example.baitapquanlynhansu.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    boolean existsByTitle(String title);
}
