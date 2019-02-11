package com.app.dao.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.entities.ProfileDetails;

public interface ProfileDetailsRespository extends CrudRepository<ProfileDetails, Long> {
	
	@Query("SELECT p FROM ProfileDetails p WHERE LOWER(p.firstName)= LOWER(:firstname)")
	public Iterable<ProfileDetails> findByFirstName(@Param("firstname") String firstname);
	
	@Query("SELECT p FROM ProfileDetails p WHERE p.skillSet LIKE %:skill%")
	public Iterable<ProfileDetails> findBySkillSet(@Param("skill") String skill);
	
	@Query("SELECT p FROM ProfileDetails p WHERE p.location LIKE %:location%")
	public Iterable<ProfileDetails> findByLocation(@Param("location") String location);
	
	@Query("SELECT p FROM ProfileDetails p WHERE p.experience >= :experience")
	public Iterable<ProfileDetails> findByExperience(@Param("experience") int experience);
}
