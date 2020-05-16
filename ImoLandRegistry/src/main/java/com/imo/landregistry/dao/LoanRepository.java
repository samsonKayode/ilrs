package com.imo.landregistry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imo.landregistry.entity.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {

}
