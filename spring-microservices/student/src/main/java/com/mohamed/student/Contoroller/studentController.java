package com.mohamed.student.Contoroller;

import com.mohamed.student.Entity.student;
import com.mohamed.student.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class studentController {


    private final studentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody student student
    ) {
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<student>> findAllStudents() {
        return ResponseEntity.ok(service.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<student>> findAllStudents(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(service.findAllStudentsBySchool(schoolId));
    }
}
