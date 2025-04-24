package com.unims.map;

import com.unims.dto.EnrollmentDto;
import com.unims.dto.EnrollmentRequest;
import com.unims.entity.Enrollment;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Named("toDto")
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    EnrollmentDto toDto(Enrollment enrollment);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "courseId", target = "course.id")
    Enrollment toEntity(EnrollmentRequest request);

    void updateEnrollmentFromRequest(EnrollmentRequest request, @MappingTarget Enrollment enrollment);

    @IterableMapping(qualifiedByName = "toDto")
    List<EnrollmentDto> toDtoList(List<Enrollment> enrollments);
}
