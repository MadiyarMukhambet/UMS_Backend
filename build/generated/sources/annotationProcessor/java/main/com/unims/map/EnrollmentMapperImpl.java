package com.unims.map;

import com.unims.dto.EnrollmentDto;
import com.unims.dto.EnrollmentRequest;
import com.unims.entity.Course;
import com.unims.entity.Enrollment;
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
public class EnrollmentMapperImpl implements EnrollmentMapper {

    @Override
    public EnrollmentDto toDto(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }

        EnrollmentDto enrollmentDto = new EnrollmentDto();

        enrollmentDto.setStudentId( enrollmentStudentId( enrollment ) );
        enrollmentDto.setCourseId( enrollmentCourseId( enrollment ) );
        enrollmentDto.setId( enrollment.getId() );
        enrollmentDto.setEnrollmentDate( enrollment.getEnrollmentDate() );

        return enrollmentDto;
    }

    @Override
    public Enrollment toEntity(EnrollmentRequest request) {
        if ( request == null ) {
            return null;
        }

        Enrollment.EnrollmentBuilder enrollment = Enrollment.builder();

        enrollment.student( enrollmentRequestToStudent( request ) );
        enrollment.course( enrollmentRequestToCourse( request ) );
        enrollment.enrollmentDate( request.getEnrollmentDate() );

        return enrollment.build();
    }

    @Override
    public void updateEnrollmentFromRequest(EnrollmentRequest request, Enrollment enrollment) {
        if ( request == null ) {
            return;
        }

        enrollment.setEnrollmentDate( request.getEnrollmentDate() );
    }

    @Override
    public List<EnrollmentDto> toDtoList(List<Enrollment> enrollments) {
        if ( enrollments == null ) {
            return null;
        }

        List<EnrollmentDto> list = new ArrayList<EnrollmentDto>( enrollments.size() );
        for ( Enrollment enrollment : enrollments ) {
            list.add( toDto( enrollment ) );
        }

        return list;
    }

    private Long enrollmentStudentId(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Student student = enrollment.getStudent();
        if ( student == null ) {
            return null;
        }
        Long id = student.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long enrollmentCourseId(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        Long id = course.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Student enrollmentRequestToStudent(EnrollmentRequest enrollmentRequest) {
        if ( enrollmentRequest == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.id( enrollmentRequest.getStudentId() );

        return student.build();
    }

    protected Course enrollmentRequestToCourse(EnrollmentRequest enrollmentRequest) {
        if ( enrollmentRequest == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.id( enrollmentRequest.getCourseId() );

        return course.build();
    }
}
