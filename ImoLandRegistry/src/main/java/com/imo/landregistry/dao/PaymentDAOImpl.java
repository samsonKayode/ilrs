package com.imo.landregistry.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imo.landregistry.entity.PaymentEntity;
import com.imo.landregistry.exceptions.ActionResult;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	PaymentRepository paymentRepo;
	//SessionFactory sessionFactory;


	@Override
	public List<PaymentEntity> findAll() {
		
		//Session session = sessionFactory.getCurrentSession();
		TypedQuery<PaymentEntity> theQuery = entityManager.createQuery("from PaymentEntity", PaymentEntity.class);
		
		List<PaymentEntity> theList = theQuery.getResultList();
		
		return theList;
	}
	

	@Override
	public ActionResult verifyPayment(String title_id, String access_code) {
		//Session session = sessionFactory.getCurrentSession();
		ActionResult actionResult=null;
		
		//String sqlString = "select * from payment where title_id=:title_id and access_code=:access_code"; 
		//Query<PaymentEntity> theQuery = session.createNativeQuery(sqlString);
		
		TypedQuery<PaymentEntity> theQuery = entityManager.createQuery("from PaymentEntity pe where "
				+ "title_id=:title_id and access_code=:access_code", PaymentEntity.class);
		
		theQuery.setParameter("title_id", title_id);
		theQuery.setParameter("access_code", access_code);
		
		List<PaymentEntity> theList = theQuery.getResultList();
		
		int totalResultFound = theList.size();
		
		if(totalResultFound>=1) {
			actionResult = new ActionResult(0, "success", System.currentTimeMillis());
		}else {
			actionResult = new ActionResult(1, "error", System.currentTimeMillis());
		}
		
		return actionResult;
	}

	
	@Override
	public ActionResult savePayment(PaymentEntity pe) {
		//Session session = sessionFactory.getCurrentSession();
		
		ActionResult actionResult;
		try {
			paymentRepo.save(pe);
			actionResult = new ActionResult(0, "success", System.currentTimeMillis());
		}
		catch(Exception nn) {
			actionResult = new ActionResult(1, "error | "+nn.getMessage(), System.currentTimeMillis());
		}
		
		return actionResult;
	}
	

}
