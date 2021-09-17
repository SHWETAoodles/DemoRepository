package com.Emp.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Emp.training.customException.BusinessException;
import com.Emp.training.customException.ControllerException;
import com.Emp.training.entity.User;
//import com.Emp.training.repository.EmployeeCrudRepo;
import com.Emp.training.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/training")

public class EmployeeController {
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
@PostMapping("/save")
public ResponseEntity<Object> addEmployee(@Valid @RequestBody User user){
	
	ResponseEntity<Object> userSaved=employeeServiceInterface.addEmployee(user);
	return new ResponseEntity<Object> (userSaved,HttpStatus.CREATED);
	
}
		
		

@GetMapping("/all")
public ResponseEntity<Object> getAllEmployees(){
ResponseEntity<Object> allUser=	employeeServiceInterface.getAllEmployees();
return new  ResponseEntity<Object> (allUser,HttpStatus.OK);
}
@GetMapping("/emp/{empid}")

public ResponseEntity<?> getEmpById(@PathVariable("empid") long empid){
	
		ResponseEntity<Object>  userById=	employeeServiceInterface.getEmpById(empid);
		return new  ResponseEntity<Object>(userById,HttpStatus.OK);
		
	
	
	
	
}
@DeleteMapping("/delete/{empid}")
public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") long empid){
		employeeServiceInterface.deleteEmpById(empid);
	return new  ResponseEntity<Void> (HttpStatus.ACCEPTED);
	
	
}
@PutMapping("/update")
public ResponseEntity<Object> updateEmployee(@RequestBody User user){
	ResponseEntity<Object> userSaved=employeeServiceInterface.addEmployee(user);
	return new ResponseEntity<Object> (userSaved,HttpStatus.CREATED);
}



//registration form jsp page


}