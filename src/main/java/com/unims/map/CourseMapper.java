package com.unims.map;

import com.unims.dto.CourseDto;
import com.unims.dto.CourseRequest;
import com.unims.entity.Course;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Named("toDto")
    CourseDto toDto(Course course);

    Course toEntity(CourseRequest request);

    void updateCourseFromRequest(CourseRequest request, @MappingTarget Course course);

    @IterableMapping(qualifiedByName = "toDto")
    List<CourseDto> toDtoList(List<Course> courses);

    @Mapping(target = "numberOfStudents", expression = "java(course.getEnrollments() == null ? 0 : course.getEnrollments().size())")
    CourseDto toDtoWithEnrollmentCount(Course course);
}
