package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.impl.ProfileDetailsRespository;
import com.app.entities.ProfileDetails;

@Service
public class ProfDetailsServiceImpl implements ProfileDetailsService {
	
	@Autowired
	ProfileDetailsRespository profDetailsRepository;

	@Override
	public ProfileDetails savePofileDetails(ProfileDetails profile) {
		
		return profDetailsRepository.save(profile);
	}

	@Override
	public ProfileDetails findByProfileId(Long profile) {
		
		return profDetailsRepository.findById(profile).get();
	}

	@Override
	public void DeleteProfile(Long profile) {
		
		profDetailsRepository.deleteById(profile);
		
	}

	@Override
	public Iterable<ProfileDetails> findAllJobs() {
		
		return profDetailsRepository.findAll();
	}

	@Override
	public Iterable<ProfileDetails> findByFirstName(String name) {
		
		return profDetailsRepository.findByFirstName(name);
	}

	@Override
	public Iterable<ProfileDetails> findBySkillSet(String skill) {
		
		return profDetailsRepository.findBySkillSet(skill);
	}

	@Override
	public Iterable<ProfileDetails> findByLocation(String location) {
		
		return profDetailsRepository.findByLocation(location);
	}

	@Override
	public Iterable<ProfileDetails> findByExperience(int experience) {
		
		return profDetailsRepository.findByExperience(experience);
	}

}
