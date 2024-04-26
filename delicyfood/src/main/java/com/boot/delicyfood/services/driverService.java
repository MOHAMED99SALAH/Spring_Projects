package com.boot.delicyfood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.delicyfood.entities.driver;
import com.boot.delicyfood.repositiries.driverRepo;

@Service
public class driverService {

	@Autowired
	driverRepo repo;

	public driver add_driver(driver driver) {

		return repo.save(driver);
	}

	public driver get_driver(String email) {

		return repo.findByEmail(email);

	}

	public boolean check_driver(String email) {

		driver _driver = repo.findByEmail(email);
		if (_driver == null) {
			return false;
		}
		return true;

	}

	public int updateStatus(boolean status, String driverEmail) {

		return repo.updateStatus(status, driverEmail);
	}

	public List<Object> get_drivers() {

		return repo.getDrivers();
	}

}
