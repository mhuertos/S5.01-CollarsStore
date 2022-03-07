package com.wc.level1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stores")
public class Store {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idStore;
	
	@Column(length = 60, unique = true)
	private String name;
	
	@Column(name="capacity")
	private int storageCapacity;
	
	@OneToMany(mappedBy = "store", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Collar> collar = new ArrayList<>();
	
	public Store() {
	}
	
	public Store(String name, int storageCapacity) {
		this.name = name;
		this.storageCapacity = storageCapacity;
	}

	public long getIdStore() {
		return idStore;
	}

	public void setIdStore(long idStore) {
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
	

	public List<Collar> getCollar() {
		return collar;
	}

	public void setCollar(List<Collar> collar) {
		this.collar = collar;
	}

	@Override
	public String toString() {
		return "Store [idStore=" + idStore + ", name=" + name + ", storageCapacity=" + storageCapacity +"]";
	}
	
	/*spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true*/
}
