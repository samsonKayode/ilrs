package com.imo.landregistry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imo.landregistry.dao.PaymentDAO;
import com.imo.landregistry.entity.PaymentEntity;
import com.imo.landregistry.exceptions.ActionResult;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentDAO paymentDAO;

	@Override
	@Transactional
	public List<PaymentEntity> findAll() {
		// TODO Auto-generated method stub
		return paymentDAO.findAll();
	}

	@Override
	@Transactional
	public ActionResult savePayment(PaymentEntity pe) {
		// TODO Auto-generated method stub
		return paymentDAO.savePayment(pe);
	}

	@Override
	@Transactional
	public ActionResult verifyPayment(String title_id, String access_code) {
		// TODO Auto-generated method stub
		return paymentDAO.verifyPayment(title_id, access_code);
	}


	


}
