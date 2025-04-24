package com.unims.strategy;

import com.unims.entity.Course;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component("studentCountFilter")
public class StudentCountFilterStrategy implements CourseFilterStrategy {
    @Override
    public List<Course> filter(List<Course> courses, String value) {
        int count = Integer.parseInt(value);
        return courses.stream()
                .filter(course -> course.getEnrollments() != null && course.getEnrollments().size() >= count)
                .collect(Collectors.toList());
    }
}
