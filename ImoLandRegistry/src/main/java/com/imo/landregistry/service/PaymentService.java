package com.imo.landregistry.service;

import java.util.List;

import com.imo.landregistry.entity.PaymentEntity;
import com.imo.landregistry.exceptions.ActionResult;

public interface PaymentService {
	
	public List<PaymentEntity> findAll();
	
	public ActionResult savePayment(PaymentEntity pe);
	
	public ActionResult verifyPayment(String title_id, String access_code);

}
