package com.imo.landregistry.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imo.landregistry.entity.LandEntity;

@Repository
public class CustomLandRepoImpl implements CustomLandRepo {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public LandEntity getSingleLand(String title_id) {
		
		String query;
		
		LandEntity landEntity = null;
		
		try {
			
			Query query2 = entityManager.createQuery("Select le from LandEntity le where le.title_id=:title_id", LandEntity.class);
			
			query2.setParameter("title_id", title_id);
			
			landEntity = (LandEntity) query2.getSingleResult();
			
		}
		catch(Exception ex) {
			
			System.out.println("Error loading information====>>>"+ex);
			
		}
		
		// TODO Auto-generated method stub
		return landEntity;
	}

}
