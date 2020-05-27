package com.imo.landregistry.dao;

import java.util.Date;

import com.imo.landregistry.paystack.InitializeTransactionRequest;
import com.imo.landregistry.paystack.InitializeTransactionResponse;
import com.imo.landregistry.paystack.VerifyTransactionResponse;

public interface InitPayment {
	
	public InitializeTransactionResponse startPayment(InitializeTransactionRequest request);
	
	public VerifyTransactionResponse verifyTransaction(String reference) throws Exception;

	void savePaystackRecord(String title_id, String access_code, String payer, Date date);

}
