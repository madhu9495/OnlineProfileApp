package com.app.service.impl;

import com.app.entities.JobDetails;


public interface JobDetailsService {
	
	public JobDetails saveJobDetails(JobDetails job);
	
	public Iterable<JobDetails> findAllJobs();

	public JobDetails findByJobId(Long jobId);

	public void DeleteJob(Long jobId);
	
	public Iterable<JobDetails> findBySkillSet(String skill);
	
	public Iterable<JobDetails> findByLocation(String location);
	
	public Iterable<JobDetails> findByExperience(int experience);

}
