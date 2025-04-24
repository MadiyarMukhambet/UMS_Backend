package com.unims.map;

import com.unims.dto.CourseDto;
import com.unims.dto.CourseRequest;
import com.unims.entity.Course;
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
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDto toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setTitle( course.getTitle() );
        courseDto.setDescription( course.getDescription() );
        courseDto.setCreatedAt( course.getCreatedAt() );

        return courseDto;
    }

    @Override
    public Course toEntity(CourseRequest request) {
        if ( request == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.title( request.getTitle() );
        course.description( request.getDescription() );

        return course.build();
    }

    @Override
    public void updateCourseFromRequest(CourseRequest request, Course course) {
        if ( request == null ) {
            return;
        }

        course.setTitle( request.getTitle() );
        course.setDescription( request.getDescription() );
    }

    @Override
    public List<CourseDto> toDtoList(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseDto> list = new ArrayList<CourseDto>( courses.size() );
        for ( Course course : courses ) {
            list.add( toDto( course ) );
        }

        return list;
    }

    @Override
    public CourseDto toDtoWithEnrollmentCount(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setTitle( course.getTitle() );
        courseDto.setDescription( course.getDescription() );
        courseDto.setCreatedAt( course.getCreatedAt() );

        courseDto.setNumberOfStudents( course.getEnrollments() == null ? 0 : course.getEnrollments().size() );

        return courseDto;
    }
}
