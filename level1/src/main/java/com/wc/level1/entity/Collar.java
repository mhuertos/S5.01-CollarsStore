package com.wc.level1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="collars")
public class Collar {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCollar;
	
	@Column(nullable=true, length = 60)
	private String author;
	
	@Column(name="name", nullable=false, length = 100)
	private String collarName;
	
	@Column
	private double price;
	
	@Column
	private Date entranceDate = new Date();
	
	@ManyToOne
	@JoinColumn(name="idStore", nullable=false)
	private Store store;
	
	public Collar() {
	}
	
	public Collar(String author, String collarName, double price, Store store) {
		this.author = author;
		this.collarName = collarName;
		this.price = price;
		this.store = store;
	}
	

	public long getIdCollar() {
		return idCollar;
	}

	public void setIdCollar(long idCollar) {
		this.idCollar = idCollar;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCollarName() {
		return collarName;
	}

	public void setCollarName(String collarName) {
		this.collarName = collarName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	

}
