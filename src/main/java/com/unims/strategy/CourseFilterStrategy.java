package com.unims.strategy;

import com.unims.entity.Course;
import java.util.List;

public interface CourseFilterStrategy {
    List<Course> filter(List<Course> courses, String value);
}
