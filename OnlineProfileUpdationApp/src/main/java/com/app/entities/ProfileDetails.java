package com.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profiledetails")
public class ProfileDetails  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long profileid;
	
	@Column(name="firstname",length=50,nullable=false)
	private String firstName;
	
	@Column(name="lastname",length=50,nullable=false)
	private String lastName;
	
	@Column(name="skillset",length=50,nullable=false)
	private String skillSet;
	
	@Column(name="location",length=50,nullable=false)
	private String location;
	
	@Column(name="dob",nullable=false)
	private Date dob;
	
	@Column(name="qualification",length=50,nullable=false)
	private String qualification;
	
	@Column(name="experience",nullable=false)
	private int experience;
	
	@Column(name="gender",length=10,nullable=false)
	private String gender;
	
	@Column(name="emailid",length=100,nullable=false)
	private String emailId;
	
	@Column(name="phonenumber",length=50,nullable=false)
	private String phoneNumber;

	public Long getProfileid() {
		return profileid;
	}

	public void setProfileid(Long profileid) {
		this.profileid = profileid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
