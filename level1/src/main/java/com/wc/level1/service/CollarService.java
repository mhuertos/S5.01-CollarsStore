package com.wc.level1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.level1.entity.Collar;
import com.wc.level1.entity.Store;
import com.wc.level1.repository.CollarRepository;

@Service
public class CollarService {
	
	@Autowired
	CollarRepository collarRepository;
	
	public CollarService(CollarRepository collarRepositor) {
		this.collarRepository = collarRepository;
	}

	public void deleteCollars(Long idStore) {
		collarRepository.deleteAll();
		
	}

	public void saveCollar(String author, String name, double price, Store store) {
		Collar collar = new Collar(author, name,price, store);
		collarRepository.save(collar);
		
	}
	
	
	
	

}
