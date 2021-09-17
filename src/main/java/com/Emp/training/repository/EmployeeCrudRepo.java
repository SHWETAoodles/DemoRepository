package com.Emp.training.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Emp.training.entity.User;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<User,Long> {





}
