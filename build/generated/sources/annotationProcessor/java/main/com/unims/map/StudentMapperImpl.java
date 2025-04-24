package com.unims.map;

import com.unims.dto.StudentDto;
import com.unims.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T21:39:43+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto toDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setName( student.getName() );
        studentDto.setEmail( student.getEmail() );

        return studentDto;
    }

    @Override
    public Student toEntity(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.id( studentDto.getId() );
        student.name( studentDto.getName() );
        student.email( studentDto.getEmail() );

        return student.build();
    }

    @Override
    public List<StudentDto> toDtoList(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( students.size() );
        for ( Student student : students ) {
            list.add( toDto( student ) );
        }

        return list;
    }
}
