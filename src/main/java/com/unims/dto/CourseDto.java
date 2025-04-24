package com.unims.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Integer numberOfStudents; // Пример дополнительного поля
}