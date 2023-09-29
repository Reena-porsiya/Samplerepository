package com.mycompany.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class UserEntity {

  @Id
  @GeneratedValue
  private Long user_Id;
  
  //@Size(min=15, message="Name should have at least 15 characters")  
  private String first_Name;
  private String last_Name;
  private String password;
  
  public UserEntity() {
	  super();
  }
  
 public UserEntity(String first_Name) {
	 super();
	 //this.employeeId = employeeId;
	 this.first_Name = first_Name;
 }

public Long getUser_Id() {
	return user_Id;
}

public void setUser_Id(Long user_Id) {
	this.user_Id = user_Id;
}

public String getFirst_Name() {
	return first_Name;
}

public void setFirst_Name(String first_Name) {
	this.first_Name = first_Name;
}

public String getLast_Name() {
	return last_Name;
}

public void setLast_Name(String last_Name) {
	this.last_Name = last_Name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
 
}