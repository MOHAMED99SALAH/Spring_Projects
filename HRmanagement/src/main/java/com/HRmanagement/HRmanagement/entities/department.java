package com.HRmanagement.HRmanagement.entities;

import java.util.List;

import org.hibernate.annotations.Formula;

import com.HRmanagement.HRmanagement.Base.Base_Entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@Entity
@Table(name = "department")
public class department extends Base_Entity<Long> {

	@NotBlank
	@NotEmpty
	@NotNull
	private String deptName;

	@Formula("(select count(*) from Employees emp where emp.dept_id= id)")
	private Long number_Of_employess;

	@OneToMany(mappedBy = "department")
	private List<Employee> emps;

}
