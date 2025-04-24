package com.unims.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EnrollmentDto {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDateTime enrollmentDate;
}