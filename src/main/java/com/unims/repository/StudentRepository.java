package com.unims.repository;
import com.unims.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email); // для валидации при регистрации или создании
}
