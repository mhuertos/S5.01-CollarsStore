package com.level1_v2.level1_version2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idStore;
	
	@Column(length = 60,
			nullable = false)
	private String name;
	
	@Column
	private int storageCapacity;
	
	/*Ho trec perquè al fer retorn de quadres associats, em surt aquest camp i es converteix en un json etern.
	@OneToMany(mappedBy="store")
	private List<Collar> collars = new ArrayList<>();*/
	
	public Store() {
	}
	
	public Store(String name, int storageCapacity) {
		this.name = name;
		this.storageCapacity = storageCapacity;
	}

	public Long getIdStore() {
		return idStore;
	}

	public void setIdStore(Long idStore) {
		this.idStore = idStore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	
	/*Això ho trec, de la mateixa manera que trec l'atribut que referencia a la columna asociada a Collar.
	public List<Collar> getCollars() {
		return collars;
	}

	public void setCollars(List<Collar> collars) {
		this.collars = collars;
	}*/
}
