package com.imo.landregistry.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title_id")
	private String title_id;
	
	@Column(name="access_code")
	private String access_code;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="payer")
	private String payer;
	
	public PaymentEntity() {}

	/*
	public PaymentEntity(String title_id, String access_code, String payer, Date date) {
		this.title_id = title_id;
		this.access_code = access_code;
		this.payer = payer;
	}
	*/
	
	public PaymentEntity(String title_id, String access_code, String payer, Date date) {
		this.title_id = title_id;
		this.access_code = access_code;
		this.date = date;
		this.payer = payer;
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

	public String getAccess_code() {
		return access_code;
	}

	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	@Override
	public String toString() {
		return "PaymentEntity [id=" + id + ", title_id=" + title_id + ", access_code=" + access_code + ", date=" + date
				+ ", payer=" + payer + "]";
	}
	
	

}
