package com.Emp.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Emp.training.ResponseHandler.ResponseHandler;
import com.Emp.training.customException.BusinessException;
import com.Emp.training.customException.EmptyInputException;
import com.Emp.training.entity.User;
import com.Emp.training.repository.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	@Autowired
	private EmployeeCrudRepo crudRepo;


	@Override
	public ResponseEntity<Object> addEmployee(User user) {
		// TODO Auto-generated method stub
	
			
		if(user.getName().isEmpty()|| user.getName().length()==0) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "please enter user name");
		}
		User savedUser=crudRepo.save(user);
		return ResponseHandler.response(HttpStatus.CREATED,false ,"user created successfully", savedUser);
		}
		

	@Override
	public ResponseEntity<Object> getAllEmployees() {
		// TODO Auto-generated method stub
	
			List<User> userList=crudRepo.findAll();
			
			if(userList.isEmpty()) {
				return ResponseHandler.response(HttpStatus.NOT_FOUND, true, "your list is empty!!");
				//throw new EmptyInputException("604","hey list is completely empty , we have nothing to return");
				
			}
			else {
			return ResponseHandler.response(HttpStatus.ACCEPTED, false, "all users from the list", userList);
			}
			
		
	}

	@Override
	public ResponseEntity<Object> getEmpById(long empid) {
		
	Optional<User> userByid=crudRepo.findById(empid);
	if(userByid.isPresent()) {
		return ResponseHandler.response(HttpStatus.NOT_FOUND,false,"user found successfully", userByid);
	}
	else {
			
		return ResponseHandler.response(HttpStatus.NOT_FOUND, true, "user id not found in the list");
		
		
	}
		
		
		
	}

	@Override
	public void deleteEmpById(long empid) {
		// TODO Auto-generated method stub
		
			
		
		crudRepo.deleteById(empid);
		
	}

}
