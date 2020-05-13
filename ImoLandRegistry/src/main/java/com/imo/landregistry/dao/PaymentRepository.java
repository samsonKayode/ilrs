package com.imo.landregistry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imo.landregistry.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
