package com.mohamed.student.repistory;

import com.mohamed.student.Entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentRepo extends JpaRepository<student, Integer> {
    List<student> findAllBySchoolId(Integer schoolId);
}
