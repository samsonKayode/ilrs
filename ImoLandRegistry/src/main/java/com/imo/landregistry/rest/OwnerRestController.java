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
import com.imo.landregistry.entity.OwnerEntity;
import com.imo.landregistry.exceptions.ActionResult;

@RequestMapping("/lrs/owner/data")
@RestController
public class OwnerRestController {
	
	@Autowired
	OwnerRepository ownerRepo;
	
	@Autowired
	LandRepository landRepo;
	
	LandEntity LE;
	
	@GetMapping("/list")
	public List<OwnerEntity> showAllOwners(){
		
		return ownerRepo.findAll();
	}
	
	//save owner details..
	
	@PostMapping("/list/{land_id}")
	public ActionResult saveData(@RequestBody OwnerEntity ownerEntity, @PathVariable Integer land_id) {
		
		ActionResult actionResult=null;
		
		LandEntity landEntity = landRepo.getOne(land_id);
		
		landEntity.setId(land_id);
		
		landEntity.addOwner(ownerEntity);
		
		try {
			ownerRepo.save(ownerEntity);
			actionResult = new ActionResult (0, "success", System.currentTimeMillis());
		}catch(Exception nn) {
			actionResult = new ActionResult (0, "error"+"/n"+nn.getMessage(), System.currentTimeMillis());
		}

		return actionResult;
	}

}
