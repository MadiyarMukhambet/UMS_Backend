package com.unims.repository;
import com.unims.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Можно добавить дополнительные методы, например, по поиску всех записей для студента или курса
    // List<Enrollment> findByStudentId(Long studentId);
    // List<Enrollment> findByCourseId(Long courseId);
}
