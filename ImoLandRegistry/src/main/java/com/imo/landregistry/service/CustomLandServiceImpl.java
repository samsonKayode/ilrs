package com.imo.landregistry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imo.landregistry.dao.CustomLandRepo;
import com.imo.landregistry.entity.LandEntity;

@Service
public class CustomLandServiceImpl implements CustomLandService {
	
	@Autowired
	CustomLandRepo customLandRepo;

	@Override
	@Transactional
	public LandEntity getSingleLand(String title_id) {
		
		LandEntity landEntity = customLandRepo.getSingleLand(title_id);
		
		return landEntity;
	}

}
