package com.imo.landregistry.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="loans")
public class LoanEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pledged_to")
	private String pledged_to;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="duration")
	private String duration;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="land_id", nullable=false)
	LandEntity landEntity;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="owner_id", nullable = false)
	OwnerEntity ownerEntity;
	
	public LoanEntity() {
		
	}

	public LoanEntity(String pledged_to, Date date, String duration) {
		this.pledged_to = pledged_to;
		this.date = date;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPledged_to() {
		return pledged_to;
	}

	public void setPledged_to(String pledged_to) {
		this.pledged_to = pledged_to;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LandEntity getLandEntity() {
		return landEntity;
	}

	public void setLandEntity(LandEntity landEntity) {
		this.landEntity = landEntity;
	}

	public OwnerEntity getOwnerEntity() {
		return ownerEntity;
	}

	public void setOwnerEntity(OwnerEntity ownerEntity) {
		this.ownerEntity = ownerEntity;
	}

}
