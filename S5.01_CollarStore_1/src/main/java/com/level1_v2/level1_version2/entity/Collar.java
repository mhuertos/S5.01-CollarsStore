package com.level1_v2.level1_version2.entity;

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
@Table(name="collar")
public class Collar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCollar;
	
	@Column(nullable=true, length = 60)
	private String author;
	
	@Column(nullable=false, length = 60)
	private String name;
	
	//Tipo de valor 'Decimal' porque se trata de dinero y necesitamos exactitud en cada transacción.
	@Column(nullable=true, columnDefinition = "Decimal(19,4)")
	private double price;
	
	@Column
	private Date entranceDate = new Date();
	
	/*A continuación la columna asociada con la clase Store 
	 * Es importante que no sea nula:cada cuadro asociado a una tienda.*/
	@ManyToOne
	@JoinColumn(name = "idStore", nullable=false)
	private Store store;
	
	public Collar() {	
	}
	
	//El constructor no se inicializa con la fecha, la fecha se adjudica al cargar la clase.
	public Collar(String author, String name, double price, Store store) {
		super();
		this.author = author;
		this.name = name;
		this.price = price;
		this.store = store;
	}

	public Long getIdCollar() {
		return idCollar;
	}

	public void setIdCollar(Long idCollar) {
		this.idCollar = idCollar;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
