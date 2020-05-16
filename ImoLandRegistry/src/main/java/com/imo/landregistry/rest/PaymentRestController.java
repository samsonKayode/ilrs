package com.imo.landregistry.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imo.landregistry.entity.PaymentEntity;
import com.imo.landregistry.exceptions.ActionResult;
import com.imo.landregistry.service.PaymentService;

@RestController
@RequestMapping("/lrs/verify")
public class PaymentRestController {
	
	@Autowired
	PaymentService paymentService;
	
	//verify access code and title id.. returns integer
	
	@GetMapping("/data/list/{title_id}/{access_code}")
	public ActionResult verifyData (@PathVariable String title_id, @PathVariable String access_code) {
		
		return paymentService.verifyPayment(title_id, access_code);
	}
	
	//Save Payment data..
	
	@PostMapping("/data")
	public ActionResult saveData(@RequestBody PaymentEntity paymentEntity) {
		
		return paymentService.savePayment(paymentEntity);
		
	}
	
	//get all the lists..
	
	@GetMapping("/data/list")
	public List<PaymentEntity> getAllData(){
		
		return paymentService.findAll();
	}
	
		
	

}
