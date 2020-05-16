package com.imo.landregistry.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="land")
public class LandEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title_id")
	private String title_id;
	
	@Column(name="location")
	private String location;
	
	@Column(name="size")
	private String size;
	
	@Column(name="description")
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="landEntity")
	private OwnerEntity ownerEntity;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="landEntity")
	private Set<LoanEntity> loanEntity;

	
	public LandEntity() {
		
	}

	public LandEntity(String title_id, String location, String size, String description) {
		this.title_id = title_id;
		this.location = location;
		this.size = size;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle_id() {
		return title_id;
	}

	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OwnerEntity getOwnerEntity() {
		return ownerEntity;
	}

	public void setOwnerEntity(OwnerEntity ownerEntity) {
		this.ownerEntity = ownerEntity;
	}
	
	public Set<LoanEntity> getLoanEntity() {
		return loanEntity;
	}

	public void setLoanEntity(Set<LoanEntity> loanEntity) {
		this.loanEntity = loanEntity;
	}

	public void addOwner(OwnerEntity tempOwner) {
		
		if(ownerEntity==null) {
			ownerEntity = null;
		}
		ownerEntity=tempOwner;
		tempOwner.setLandEntity(this);
	}
	
	public void addLoans(LoanEntity tempLoan) {
		
		if(loanEntity==null) {
			loanEntity = new HashSet<>();
		}
		loanEntity.add(tempLoan);
		tempLoan.setLandEntity(this);		
	}
	
	
}
