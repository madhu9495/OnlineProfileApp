package com.app.dao.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.entities.JobDetails;


public interface JobDetailsRespository extends CrudRepository<JobDetails, Long> {
	
	@Query("SELECT j FROM JobDetails j WHERE j.skillsRequired LIKE %:skill%")
	public Iterable<JobDetails> findBySkillSet(@Param("skill") String skill);
	
	@Query("SELECT j FROM JobDetails j WHERE j.location LIKE %:location%")
	public Iterable<JobDetails> findByLocation(@Param("location") String location);
	
	@Query("SELECT j FROM JobDetails j WHERE j.experience >= :experience")
	public Iterable<JobDetails> findByExperience(@Param("experience") int experience);


}
