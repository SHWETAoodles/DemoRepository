package com.Emp.training.repository;



	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.Emp.training.entity.Role;

import java.util.Optional;

	@Repository
	public interface RoleCrudRepository  extends JpaRepository<Role, Long> {
	 
	}


