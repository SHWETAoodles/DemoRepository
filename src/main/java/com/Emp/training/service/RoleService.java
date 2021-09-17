package com.Emp.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp.training.entity.Role;
import com.Emp.training.entity.User;
import com.Emp.training.repository.RoleCrudRepository;
@Service
public class RoleService implements RoleServiceInterface {
	@Autowired
	
	private RoleCrudRepository roleRepo;
	public Role addRole(Role  role) {
		Role savedRole=roleRepo.save(role);
		return savedRole;
		
	}
	public List<Role> getAllRoles() {
		 return roleRepo.findAll();
		
	}

	
	public void deleteRoleById(long roleId) {
		roleRepo.deleteById(roleId);
	}
	@Override
	public Role findRoleById(long roleId) {
		// TODO Auto-generated method stub
		return roleRepo.findById(roleId).get();
	}


}
