package com.unims.map;

import com.unims.dto.StudentDto;
import com.unims.entity.Student;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
    List<StudentDto> toDtoList(List<Student> students);
}
