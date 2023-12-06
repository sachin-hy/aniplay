package com.aniplay.AnimeSite.entities;



import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserDetail {

	@Id
	private String email;
	private String name;
	private String password;
	private Date registerdate;
	

    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	
	
	@Override
	public String toString() {
		return "UserDetail [email=" + email + ", name=" + name + ", password=" + password + ", registerdate="
				+ registerdate + "]";
	}
	
	
	
}
