package com.imo.landregistry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imo.landregistry.entity.LandEntity;

public interface LandRepository extends JpaRepository<LandEntity, Integer> {

}
