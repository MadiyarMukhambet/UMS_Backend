package com.unims.service;
import com.unims.dto.StudentDto;
import com.unims.entity.Student;
import com.unims.factory.StudentFactory;
import com.unims.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDto create(StudentDto dto) {
        Student student = StudentFactory.fromDto(dto);
        return StudentFactory.toDto(studentRepository.save(student));
    }

    public List<StudentDto> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentFactory::toDto)
                .collect(Collectors.toList());
    }

    public StudentDto findById(Long id) {
        return studentRepository.findById(id)
                .map(StudentFactory::toDto)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentDto update(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        return StudentFactory.toDto(studentRepository.save(student));
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
