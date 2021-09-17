package com.Emp.training.service;

import java.util.List;

import com.Emp.training.entity.Role;


public interface RoleServiceInterface {

	public Role addRole(Role role);
	public List<Role> getAllRoles();

	public void deleteRoleById(long roleId);
	public Role findRoleById(long roleId);


}
