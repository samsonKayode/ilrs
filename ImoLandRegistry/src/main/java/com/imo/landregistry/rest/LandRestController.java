package com.imo.landregistry.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imo.landregistry.dao.LandRepository;
import com.imo.landregistry.dao.OwnerRepository;
import com.imo.landregistry.entity.LandEntity;
import com.imo.landregistry.service.CustomLandService;

@RequestMapping("/lrs/lands/data")
@RestController
public class LandRestController {
	
	@Autowired
	LandRepository landRepo;
	
	@Autowired
	OwnerRepository ownerRepo;
	
	@Autowired
	CustomLandService landService;
	
	
	
	//show land details
	
	@GetMapping("/list")
	public List<LandEntity> showAllLands(){
		
		return landRepo.findAll();
	}
	
	//get single with titleID..
	
	@GetMapping("/list/{title_id}")
	public LandEntity getSigleTitle(@PathVariable String title_id) {
		
		LandEntity landEntity=null;
		
		landEntity = landService.getSingleLand(title_id);
		
		return landEntity;
		
	}
	
	
	//save land details..
	
	@PostMapping("/list")
	public void saveData(@RequestBody LandEntity landEntity) {
		
		landRepo.save(landEntity);
	}

}
