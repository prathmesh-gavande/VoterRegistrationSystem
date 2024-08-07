package com.votingSystem.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Voter {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name can not br blank")
	@Pattern(regexp = "^a-zA-Z+$")
	private String voterName;
	private Date dob;
	private String gender;
	private String username;
	private String password;
	public Voter(@NotBlank(message = "Name can not br blank") @Pattern(regexp = "^a-zA-Z+$") String voterName, Date dob,
			String gender, String username, String password) {
		super();
		this.voterName = voterName;
		this.dob = dob;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
