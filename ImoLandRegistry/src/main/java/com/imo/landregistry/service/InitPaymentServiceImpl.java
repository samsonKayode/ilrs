package com.imo.landregistry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imo.landregistry.dao.InitPayment;
import com.imo.landregistry.paystack.InitializeTransactionRequest;
import com.imo.landregistry.paystack.InitializeTransactionResponse;
import com.imo.landregistry.paystack.VerifyTransactionResponse;

@Service
public class InitPaymentServiceImpl implements InitPaymentService {
	
	@Autowired
	InitPayment initPayment;

	@Override
	public InitializeTransactionResponse startPayment(InitializeTransactionRequest request) {
		
		InitializeTransactionResponse initResponse=null;
		
		initResponse = initPayment.startPayment(request);
		
		return initResponse;
	}

	@Override
	public VerifyTransactionResponse verifyTransaction(String reference) {
		
		VerifyTransactionResponse initResponse=null;
		
		try {
			initResponse = initPayment.verifyTransaction(reference);
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		return initResponse;
	}

}
