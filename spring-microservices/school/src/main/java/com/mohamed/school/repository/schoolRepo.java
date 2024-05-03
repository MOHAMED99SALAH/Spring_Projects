package com.mohamed.school.repository;

import com.mohamed.school.entity.school;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface schoolRepo extends JpaRepository<school, Integer> {
}
