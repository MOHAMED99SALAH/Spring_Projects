package com.mohamed.school.service;



import com.mohamed.school.Client.StudentClient;
import com.mohamed.school.entity.school;
import com.mohamed.school.repository.schoolRepo;
import com.mohamed.school.response.FullSchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class schoolService {

      @Autowired
      schoolRepo repository;
     @Autowired
      StudentClient client;

    public void saveSchool(school school) {
        repository.save(school);
    }

    public List<school> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        com.mohamed.school.entity.school.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );

        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
