package com.unims.factory;
import com.unims.dto.StudentDto;
import com.unims.entity.Student;

public class StudentFactory {
    public static Student fromDto(StudentDto dto) {
        return Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }
}
