package com.Emp.training.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.Emp.training.annotation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//import com.Emp.training.annotation.ValidPassword;

//import com.Emp.training.annotation.UniqueUserName;

@Entity
@Table(name="user")
@JsonIdentityInfo(

        generator = ObjectIdGenerators.PropertyGenerator.class,

        property = "id")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
//	@OneToOne(cascade=CascadeType.ALL)
//
//	private Role role;
	
	@NotEmpty
	@Size(min=2, message="user name should have atleast two chracters" )
	//@UniqueUserName(message="Such userName already Exist")
	private String name;
	private String address;
	
	@NotEmpty
	@Email(message="invalid email address..... please enter valid email")
	private String Email;
	@NotEmpty

	@ValidPassword
	private String password;
   //@NotEmpty
  // @Size(max=10,message="invalid phone number")
	private Long phoneNumber;
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL )
	
	
	

	 
	     private List<Role> roles;
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", Email=" + Email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", roles=" + roles + "]";
	}
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}

	public User(Role role,
			@NotEmpty @Size(min = 2, message = "user name should have atleast two chracters") String name,
			String address,
			@NotEmpty @javax.validation.constraints.Email(message = "invalid email address..... please enter valid email") String email,
			@NotEmpty String password, Long phoneNumber, List<Role> roles) {
		super();
//		this.role = role;
		this.name = name;
		this.address = address;
		this.Email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
