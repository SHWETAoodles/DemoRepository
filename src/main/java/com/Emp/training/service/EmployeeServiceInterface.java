package com.Emp.training.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Emp.training.entity.User;

public interface EmployeeServiceInterface {

	public ResponseEntity<Object> addEmployee(User user);

	public ResponseEntity<Object> getAllEmployees();

	public ResponseEntity<Object> getEmpById(long empid);

	public void deleteEmpById(long empid);

}
