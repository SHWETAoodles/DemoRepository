package com.Emp.training.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Emp.training.entity.Role;

import com.Emp.training.service.RoleServiceInterface;

@RestController
@RequestMapping("/Role")
public class RoleController{
	@Autowired
private	RoleServiceInterface roleServiceInterface;
	@PostMapping("/saveRole")
	public ResponseEntity<Role>  saveRoll(Role role) {
		
		
		Role roleSaved=roleServiceInterface.addRole(role);
		return new ResponseEntity<Role> (roleSaved,HttpStatus.CREATED);
		
		
		
	}
	@GetMapping("/getAllRole")
	public ResponseEntity<List<Role>> getallRoles(){
		List<Role> allRole=	roleServiceInterface.getAllRoles();
		return new  ResponseEntity<List<Role>> (allRole,HttpStatus.OK);
		
	}
	
	@GetMapping("/role/{roleId}")
	public ResponseEntity<Role> findRoleById(@PathVariable("roleId") long roleId){
		
			Role roleById=roleServiceInterface.findRoleById(roleId);
			return new  ResponseEntity<> (roleById,HttpStatus.OK);
			
	}
	
	@DeleteMapping("/delete/{roleId}")
	public ResponseEntity<Void> deleteRoleById(@PathVariable("roleid") long roleId){
	roleServiceInterface.deleteRoleById(roleId);
		return new  ResponseEntity<Void> (HttpStatus.ACCEPTED);
		
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Role> updateRole(@RequestBody Role role){
		Role roleSaved=roleServiceInterface.addRole(role);
		return new ResponseEntity<Role> (roleSaved,HttpStatus.CREATED);
	
	}
}


