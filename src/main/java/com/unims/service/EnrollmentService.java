package com.unims.service;
import com.unims.dto.*;
import com.unims.entity.*;
import com.unims.exception.*;
import com.unims.map.EnrollmentMapper;
import com.unims.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentDto create(EnrollmentRequest request) {
        // Проверка на существование студента и курса
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student not found with ID: " + request.getStudentId()));
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found with ID: " + request.getCourseId()));

        // Создание записи о зачислении
        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .enrollmentDate(request.getEnrollmentDate())
                .build();

        return enrollmentMapper.toDto(enrollmentRepository.save(enrollment));
    }

    public List<EnrollmentDto> findAll() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public EnrollmentDto findById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Enrollment not found with ID: " + id));
        return enrollmentMapper.toDto(enrollment);
    }

    public EnrollmentDto update(Long id, EnrollmentRequest request) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Enrollment not found with ID: " + id));

        // Обновление данных
        enrollmentMapper.updateEnrollmentFromRequest(request, enrollment);
        return enrollmentMapper.toDto(enrollmentRepository.save(enrollment));
    }

    public void delete(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new NotFoundException("Enrollment not found with ID: " + id);
        }
        enrollmentRepository.deleteById(id);
    }
}
