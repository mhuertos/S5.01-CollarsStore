package com.level1_v2.level1_version2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.level1_v2.level1_version2.entity.Collar;
import com.level1_v2.level1_version2.entity.Store;
import com.level1_v2.level1_version2.repository.CollarRepository;

@Service
public class CollarService {
	
	@Autowired
	CollarRepository collarRepository;
	
	public CollarService(CollarRepository collarRepository) {
		this.collarRepository = collarRepository;
	}
	
	//VERSIÓN 1 (SIN MIRAR LA CAPACIDAD DE LA TIENDA)
	/*public void saveCollar(String author, String name, double price, Store store) {
		collarRepository.save(new Collar(author, name, price, store));
	}*/
	
	//VERSIÓN 2 (CONTEMPLANDO LA CAPACIDAD DE LA TIENDA)
	public void saveCollar(String author, String name, double price, Store store) {
		int storageCapacity = store.getStorageCapacity();
		if(storageCapacity > collarRepository.countByStore(store)) {
			collarRepository.save(new Collar(author, name, price, store));
		}else {
			throw new IllegalStateException("No hi ha més espai a la botiga");
		}
	}
	
	
	@Transactional
	public void deleteCollars(Store store) {
		collarRepository.deleteByStore(store);
	}

	public List<Collar> showCollars(Store store) {
		return collarRepository.findByStore(store);
	}
	
	//Prova
	public List<Collar> showCollarsByFields(Store store){
		return collarRepository.findAuthorAndNameAndPriceByStore(store);
	}
	

}
