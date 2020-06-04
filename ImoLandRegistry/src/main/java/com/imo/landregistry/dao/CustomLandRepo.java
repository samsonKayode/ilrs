package com.imo.landregistry.dao;

import com.imo.landregistry.entity.LandEntity;

public interface CustomLandRepo {
	
	public LandEntity getSingleLand(String title_id);

}
