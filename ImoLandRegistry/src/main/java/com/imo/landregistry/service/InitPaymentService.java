package com.imo.landregistry.service;

import com.imo.landregistry.paystack.InitializeTransactionRequest;
import com.imo.landregistry.paystack.InitializeTransactionResponse;
import com.imo.landregistry.paystack.VerifyTransactionResponse;

public interface InitPaymentService {
	
	public InitializeTransactionResponse startPayment(InitializeTransactionRequest request);
	
	public VerifyTransactionResponse verifyTransaction(String reference);


}
