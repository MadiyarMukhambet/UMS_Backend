package com.unims.controller;
import com.unims.dto.*;
import com.unims.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDto> create(@RequestBody EnrollmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> findAll() {
        return ResponseEntity.ok(enrollmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDto> update(@PathVariable Long id, @RequestBody EnrollmentRequest request) {
        return ResponseEntity.ok(enrollmentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
