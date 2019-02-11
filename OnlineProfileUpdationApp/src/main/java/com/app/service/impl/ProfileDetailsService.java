package com.app.service.impl;


import com.app.entities.ProfileDetails;

public interface ProfileDetailsService {

	public ProfileDetails savePofileDetails(ProfileDetails profile);
	
	public Iterable<ProfileDetails> findAllJobs();
	
	public Iterable<ProfileDetails> findByFirstName(String name);
	
	public Iterable<ProfileDetails> findBySkillSet(String skill);
	
	public Iterable<ProfileDetails> findByLocation(String location);
	
	public Iterable<ProfileDetails> findByExperience(int experience);

	public ProfileDetails findByProfileId(Long profileId);

	public void DeleteProfile(Long profileId);

}
