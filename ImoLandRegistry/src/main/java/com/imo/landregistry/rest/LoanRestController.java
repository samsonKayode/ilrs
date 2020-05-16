package com.imo.landregistry.rest;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imo.landregistry.dao.LandRepository;
import com.imo.landregistry.dao.LoanRepository;
import com.imo.landregistry.dao.OwnerRepository;
import com.imo.landregistry.entity.LandEntity;
import com.imo.landregistry.entity.LoanEntity;
import com.imo.landregistry.entity.OwnerEntity;
import com.imo.landregistry.exceptions.ActionResult;

@RestController
@RequestMapping("/lrs/loans")
public class LoanRestController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	LoanRepository loanRepo;
	
	@Autowired
	LandRepository landRepo;
	
	@Autowired
	OwnerRepository ownerRepo;
	
	
	//Get all loans..
	
	//@GetMapping Loan
	
	@GetMapping("/data/list")
	public List<LoanEntity> getAllLoans(){
		
		return loanRepo.findAll();
	}
	
	
	//Save all Loans..
	
	
	@PostMapping("/data/list/{land_id}/{owner_id}")
	public ActionResult saveData(@RequestBody LoanEntity loanEntity, @PathVariable Integer land_id, @PathVariable Integer owner_id) {
		
		ActionResult actionResult=null;
		LandEntity landEntity = landRepo.getOne(land_id);
		landEntity.setId(land_id);
		
		OwnerEntity ownerEntity = ownerRepo.getOne(owner_id);
		ownerEntity.setId(owner_id);
		
		landEntity.addOwner(ownerEntity);
		
		landEntity.addLoans(loanEntity);
		ownerEntity.addLoans(loanEntity);
		
		try {
			
			loanRepo.save(loanEntity);
			
			actionResult = new ActionResult(0, "success", System.currentTimeMillis());
		}
		catch(Exception nn) {
			actionResult = new ActionResult(1, "error", System.currentTimeMillis());

		}
		
		return actionResult;
	}

}
