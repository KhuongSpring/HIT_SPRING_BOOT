package com.example.demo.repositories;

import com.example.demo.models.entities.Class;
import com.example.demo.models.entities.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean findByEmail(@Email String email);

    boolean existsByEmail(@Email String email);

    Object findByName(@Size(min = 3) String name);

    Object findByClassesId(Long classId);
}
