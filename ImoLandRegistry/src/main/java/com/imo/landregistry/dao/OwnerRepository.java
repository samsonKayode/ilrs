package com.imo.landregistry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imo.landregistry.entity.OwnerEntity;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer> {

}
