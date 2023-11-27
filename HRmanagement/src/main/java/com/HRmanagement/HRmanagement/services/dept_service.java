package com.HRmanagement.HRmanagement.services;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.HRmanagement.HRmanagement.entities.department;
import com.HRmanagement.HRmanagement.error.RecordNotFound;
import com.HRmanagement.HRmanagement.repositories.dept_Repo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class dept_service {

	private final dept_Repo deptRepo;

	Logger log = LoggerFactory.getLogger(dept_service.class);

	public Optional<department> findById(Long id) {

		Optional<department> dept = deptRepo.findById(id);

		if (dept.isPresent()) {
			return dept;
		} else {
			log.error("id is null");
			throw new RecordNotFound("Record Not Found");

		}

	}

	public department getbyid(Long id) {
		return deptRepo.getById(id);
	}

	public List<department> findAll() {
		return deptRepo.findAll();

	}

	public department insrt(department entity) {
		log.info("entity is inserted successfully");
		return deptRepo.save(entity);

	}

	public department update(department entity) {
		log.info("entity is updated successfully");
		return deptRepo.save(entity);
	}

	public void deleteById(Long id) {

		Optional<department> dept = deptRepo.findById(id);

		if (dept.isPresent()) {
			deptRepo.deleteById(id);
		} else {
			log.info("entity is deleted successfully");
			throw new RecordNotFound("Record Not Found");

		}

	}

}
