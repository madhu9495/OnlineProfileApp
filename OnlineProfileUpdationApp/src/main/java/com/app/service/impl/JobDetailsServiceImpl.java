package com.app.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.impl.JobDetailsRespository;
import com.app.entities.JobDetails;

@Service
public class JobDetailsServiceImpl implements JobDetailsService{
	
	@Autowired
	JobDetailsRespository jobDetailsRespository;

	public JobDetails saveJobDetails(JobDetails job) {
		
		return jobDetailsRespository.save(job);
	}

	@Override
	public JobDetails findByJobId(Long jobId) {
		
		return jobDetailsRespository.findById(jobId).get();
	}

	@Override
	public Iterable<JobDetails> findAllJobs() {
		
		return jobDetailsRespository.findAll();
	}

	@Override
	public void DeleteJob(Long jobId) {
		
		 jobDetailsRespository.deleteById(jobId);
		
	}

	@Override
	public Iterable<JobDetails> findBySkillSet(String skill) {
		
		return jobDetailsRespository.findBySkillSet(skill);
	}

	@Override
	public Iterable<JobDetails> findByLocation(String location) {
		
		return jobDetailsRespository.findByLocation(location);
	}

	@Override
	public Iterable<JobDetails> findByExperience(int experience) {
		
		return jobDetailsRespository.findByExperience(experience);
	}



}
