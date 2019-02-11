package com.app.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobdetails")
public class JobDetails  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobid;
	
	@Column(name="jobname",length=100,nullable=false)
	private String jobName;
	
	@Column(name="jobdescription",length=2000,nullable=false)
	private String jobDescription;
	
	@Column(name="projectname",length=100,nullable=false)
	private String projectName;
	
	@Column(name="skillsrequired",length=500,nullable=false)
	private String skillsRequired;
	
	@Column(name="optionalskills",length=500,nullable=false)
	private String optionalSkills;
	
	@Column(name="location",length=50,nullable=false)
	private String location;
	
	@Column(name="employeeband",length=50,nullable=false)
	private String employeeBand;
	
	@Column(name="experience",nullable=false)
	private int experience;
	
	@Column(name="noofpositions",nullable=false)
	private int noOfPositions;
	
	@Column(name="emailid",length=100,nullable=false)
	private String emailId;
	
	@Column(name="phonenumber",length=50,nullable=false)
	private String phoneNumber;
	
	

	public Long getJobid() {
		return jobid;
	}

	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public String getOptionalSkills() {
		return optionalSkills;
	}

	public void setOptionalSkills(String optionalSkills) {
		this.optionalSkills = optionalSkills;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmployeeBand() {
		return employeeBand;
	}

	public void setEmployeeBand(String employeeBand) {
		this.employeeBand = employeeBand;
	}

	

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getNoOfPositions() {
		return noOfPositions;
	}

	public void setNoOfPositions(int noOfPositions) {
		this.noOfPositions = noOfPositions;
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
