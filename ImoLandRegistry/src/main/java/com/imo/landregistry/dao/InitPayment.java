package com.imo.landregistry.dao;

import com.imo.landregistry.paystack.InitializeTransactionRequest;
import com.imo.landregistry.paystack.InitializeTransactionResponse;
import com.imo.landregistry.paystack.VerifyTransactionResponse;

public interface InitPayment {
	
	public InitializeTransactionResponse startPayment(InitializeTransactionRequest request);
	
	public VerifyTransactionResponse verifyTransaction(String reference) throws Exception;

}
