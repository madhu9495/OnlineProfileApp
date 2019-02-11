package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entities.JobDetails;
import com.app.service.impl.JobDetailsServiceImpl;
import com.app.service.impl.ProfDetailsServiceImpl;


@Controller
@RequestMapping("profileApp/Admin")
public class AdminController {

	@Autowired
	JobDetailsServiceImpl jobdetailserviceImpl;
	
	@Autowired
	ProfDetailsServiceImpl profileserviceImpl;
	
	@GetMapping(value="/home")
	 public String index() {
	        return "admin-home";
	    }
	
	
	@GetMapping(value="/addjob")
	public String CreateJobDetails(Model model) {
		model.addAttribute("jobdetails", new JobDetails());
		return "editjob";
	}
	
	 @PostMapping(value = "/savejob")
	 public String saveJobdetails(JobDetails jobdetails, Model model) {
		 
		 JobDetails job= jobdetailserviceImpl.saveJobDetails(jobdetails);
		 
	     model.addAttribute("job",job);
	      return "AddJobSuccess";
	    }
	 
	 @GetMapping(value="/alljobdetails")
	 public String AllJobDetails(Model model) {
			model.addAttribute("jobdetails", jobdetailserviceImpl.findAllJobs());
			return "jobdetails";
		}
	 
	 @GetMapping(value="/jobdetails/edit/{id}")
	 public String UpdateJobDetails(Model model, @PathVariable(value = "id") Long jobid) {
		 
		 model.addAttribute("jobdetails",jobdetailserviceImpl.findByJobId(jobid));
		 
		 return "editjob";
		 
	 }
	 
	 @GetMapping(value = "/jobdetails/delete/{id}")
	  public String deleteProduct(@PathVariable(name = "id") Long jobid) {
	        jobdetailserviceImpl.DeleteJob(jobid);
	        return "redirect:/profileApp/Admin/alljobdetails";
	    }
	 
	 @GetMapping(value ="/searchbyname")
	 public String SearchResumeByname(Model model, @RequestParam(value="name") String name) {
		
			 model.addAttribute("resume",profileserviceImpl.findByFirstName(name));
		 
		 return "resumelist";
		  
	 }
	 
	 @GetMapping(value ="/searchbyskill")
	 public String SearchResumeByskill(Model model, @RequestParam(value="skill") String skill) {
		
			 model.addAttribute("resume",profileserviceImpl.findBySkillSet(skill));
		 
		 return "resumelist";
		  
	 }
	
	 @GetMapping(value ="/searchbylocation")
	 public String SearchResumeBylocation(Model model, @RequestParam(value="location") String location) {
		
			 model.addAttribute("resume",profileserviceImpl.findByLocation(location));
		 
		 return "resumelist";
		  
	 }
	 
	 @GetMapping(value ="/searchbyexperience")
	 public String SearchResumeByexperience(Model model, @RequestParam(value="experience") int experience) {
		
			 model.addAttribute("resume",profileserviceImpl.findByExperience(experience));
		 
		 return "resumelist";
		  
	 }
	
	
	 
	 

}
