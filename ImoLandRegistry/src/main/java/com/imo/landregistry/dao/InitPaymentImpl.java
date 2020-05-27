package com.imo.landregistry.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.imo.landregistry.paystack.InitializeTransactionRequest;
import com.imo.landregistry.paystack.InitializeTransactionResponse;
import com.imo.landregistry.paystack.VerifyTransactionResponse;

@Repository
public class InitPaymentImpl implements InitPayment {
	
	private static final int STATUS_CODE_OK = 200;
	@Value("${paystack.testkey}")
	private String secretKey;

	@Override
	public InitializeTransactionResponse startPayment(InitializeTransactionRequest request) {
		
		InitializeTransactionResponse initializeTransactionResponse = null;
		
		try {
            // convert transaction to json then use it as a body to post json
            Gson gson = new Gson();
            // add paystack chrges to the amount
            StringEntity postingString = new StringEntity(gson.toJson(request));
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost("https://api.paystack.co/transaction/initialize");
            post.setEntity(postingString);
            post.addHeader("Content-type", "application/json");
            post.addHeader("Authorization", "Bearer "+secretKey);
            StringBuilder result = new StringBuilder();
            HttpResponse response = client.execute(post);
            
            int STATUSR = response.getStatusLine().getStatusCode();
            
            if (response.getStatusLine().getStatusCode() == STATUS_CODE_OK) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

            } else {
                throw new Exception("Error Occurred while initializing transaction : STATUS RESPONSE ====>>>"+STATUSR);
            }
            ObjectMapper mapper = new ObjectMapper();

            initializeTransactionResponse = mapper.readValue(result.toString(), InitializeTransactionResponse.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            //throw new Exception("Failure initializaing paystack transaction");
        }

		return initializeTransactionResponse;
	}
	
	@Override
	public VerifyTransactionResponse verifyTransaction(String reference) throws Exception {
		
		VerifyTransactionResponse paystackresponse;
	
		HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://api.paystack.co/transaction/verify/" + reference);
        
        request.addHeader("Content-type", "application/json");
        request.addHeader("Authorization", "Bearer " + secretKey);
        
        StringBuilder result = new StringBuilder();
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() == STATUS_CODE_OK) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

        } else {
            throw new Exception("Error Occured while connecting to paystack url");
        }
        
        ObjectMapper mapper = new ObjectMapper();

        paystackresponse = mapper.readValue(result.toString(), VerifyTransactionResponse.class);

        if (paystackresponse == null || paystackresponse.getStatus().equals("false")) {
            throw new Exception("An error occurred while  verifying payment");
        } else if (paystackresponse.getData().getStatus().equals("success")) {
           System.out.println("verification complete!!!");
        }
		
        return paystackresponse;
	}
}
