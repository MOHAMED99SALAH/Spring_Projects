package com.mohamed.student.service;

import com.mohamed.student.Entity.student;
import com.mohamed.student.repistory.studentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class studentService {

    private final studentRepo repository;

    public void saveStudent(student student) {
        repository.save(student);
    }

    public List<student> findAllStudents() {
        return repository.findAll();
    }

    public List<student> findAllStudentsBySchool(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }


}
