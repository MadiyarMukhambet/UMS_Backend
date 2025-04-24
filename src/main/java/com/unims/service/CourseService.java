package com.unims.service;
import com.unims.dto.*;
import com.unims.entity.Course;
import com.unims.exception.NotFoundException;
import com.unims.map.CourseMapper;
import com.unims.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.unims.strategy.CourseFilterContext;
import com.unims.strategy.CourseFilterStrategy;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseFilterContext filterContext;
    public List<CourseDto> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDtoWithEnrollmentCount)
                .collect(Collectors.toList());
    }

    public CourseDto findById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with ID: " + id));
        return courseMapper.toDtoWithEnrollmentCount(course);
    }

    public CourseDto update(Long id, CourseRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with ID: " + id));
        courseMapper.updateCourseFromRequest(request, course);
        return courseMapper.toDtoWithEnrollmentCount(courseRepository.save(course));
    }

    public CourseDto create(CourseRequest request) {
        Course course = courseMapper.toEntity(request);
        return courseMapper.toDtoWithEnrollmentCount(courseRepository.save(course));
    }

    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new NotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }

    public List<CourseDto> filterCourses(String strategyKey, String value) {
        List<Course> allCourses = courseRepository.findAll();
        CourseFilterStrategy strategy = filterContext.getStrategy(strategyKey);
        return strategy.filter(allCourses, value)
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }
}
