package com.imo.landregistry.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.imo.landregistry.paystack.InitializeTransactionRequest;
import com.imo.landregistry.paystack.InitializeTransactionResponse;
import com.imo.landregistry.paystack.VerifyTransactionResponse;
import com.imo.landregistry.service.InitPaymentService;

@RestController
@RequestMapping("/lrs/payment")
public class PayStackPaymentController {
	
	@Autowired
	InitPaymentService paymentService;
	
	@PostMapping("/makepayment")
	public InitializeTransactionResponse makePayment(@RequestBody InitializeTransactionRequest request) {
		
		InitializeTransactionResponse response=null;
		
		response = paymentService.startPayment(request);
		
		return response;
	}
	
	@GetMapping("/verifytransaction/{reference}")
	public VerifyTransactionResponse verifyPayment(@PathVariable String reference) {
		
		VerifyTransactionResponse response=null;
		
		try {
			
			response = paymentService.verifyTransaction(reference);
		}
		catch(Exception ee) {
			System.out.println("Error verifying payment");
		}
		
		
		
		return response;
	}
	
	@GetMapping("/verifytransaction/{reference}/{email}/{title_id}")
	public RedirectView verifyPaymentToSave(@PathVariable String reference, @PathVariable String email, 
			@PathVariable String title_id) {
		
		RedirectView redirectView = new RedirectView();
		
		try {
			
			paymentService.verifyTransactionToSave(reference, email, title_id);
			redirectView.setUrl("http://localhost:8081/lrs/success");
		}
		catch(Exception ee) {
			System.out.println("Error verifying payment");
			
			redirectView.setUrl("http://localhost:8081/lrs/failed");
		}
		
		return redirectView;
	}
	
}
