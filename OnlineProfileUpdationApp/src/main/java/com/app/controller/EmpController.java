package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entities.JobDetails;
import com.app.entities.ProfileDetails;
import com.app.service.impl.JobDetailsServiceImpl;
import com.app.service.impl.ProfDetailsServiceImpl;

@Controller
@RequestMapping("profileApp/employee")
public class EmpController {

	@Autowired
	ProfDetailsServiceImpl profDetailsServiceImpl;
	
	@Autowired
	JobDetailsServiceImpl jobdetailserviceImpl;

	@GetMapping(value = "/home")
	public String home() {
		return "emp-home";
	}

	@GetMapping(value = "/addprofile")
	public String CreateProfileDetails(Model model) {
		model.addAttribute("profiledetails", new ProfileDetails());
		return "editprofile";
	}

	@PostMapping(value = "/saveprofile")
	public String saveProfieldetails(ProfileDetails profiledetails, Model model) {

		ProfileDetails profile = profDetailsServiceImpl.savePofileDetails(profiledetails);

		model.addAttribute("profile", profile);

		return "AddProfileSuccess";
	}

	@GetMapping(value = "/profile/edit/{id}")
	public String UpdateProfileDetails(Model model, @PathVariable(value = "id") Long profileid) {

		model.addAttribute("profiledetails", profDetailsServiceImpl.findByProfileId(profileid));

		return "editprofile";
	}

	@GetMapping(value = "/profile/delete/{id}")

	public String deleteProduct(@PathVariable(name = "id") Long profileid) {

		profDetailsServiceImpl.DeleteProfile(profileid);

		return "redirect:/profileApp/employee/allprofiles";

	}
	
	@GetMapping(value="/allprofiles")
	
	public String AllProfiles(Model model){
		
		model.addAttribute("profiledetails", profDetailsServiceImpl.findAllJobs());
		
		return "profileslist";
		
	}
	
	
	@GetMapping(value ="/searchbyskill")
	 public String SearchResumeByskill(Model model, @RequestParam(value="skill") String skill) {
		
			 model.addAttribute("job",jobdetailserviceImpl.findBySkillSet(skill));
		 
		 return "joblist";
		  
	 }
	
	 @GetMapping(value ="/searchbylocation")
	 public String SearchResumeBylocation(Model model, @RequestParam(value="location") String location) {
		
			 model.addAttribute("job",jobdetailserviceImpl.findByLocation(location));
		 
		 return "joblist";
		  
	 }
	 
	 @GetMapping(value ="/searchbyexperience")
	 public String SearchResumeByexperience(Model model, @RequestParam(value="experience") int experience) {
		
			 model.addAttribute("job",jobdetailserviceImpl.findByExperience(experience));
		 
		 return "joblist";
		  
	 }


}
