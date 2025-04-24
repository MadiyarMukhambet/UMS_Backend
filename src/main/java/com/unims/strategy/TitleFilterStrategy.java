package com.unims.strategy;

import com.unims.entity.Course;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component("titleFilter")
public class TitleFilterStrategy implements CourseFilterStrategy {
    @Override
    public List<Course> filter(List<Course> courses, String value) {
        return courses.stream()
                .filter(course -> course.getTitle() != null && course.getTitle().toLowerCase().contains(value.toLowerCase()))
                .collect(Collectors.toList());
    }
}
