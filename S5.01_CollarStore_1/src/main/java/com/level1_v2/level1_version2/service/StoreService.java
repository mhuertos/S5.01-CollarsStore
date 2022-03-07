package com.level1_v2.level1_version2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.level1_v2.level1_version2.entity.Store;
import com.level1_v2.level1_version2.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	StoreRepository storeRepository;
	
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	public List<Store> showStores() {
		return storeRepository.findAll();
		
	}

	/*Aquesta funció la he necessitat en numeroses ocasiones per obtenir una instància de Store
	 * que posteriorment traballés per recuperar instàncies de 'Collar"*/
	public Store getOneStore(Long idCollar) {
		return storeRepository.findById(idCollar).orElseThrow(
				() -> new IllegalStateException("There is not any store with id = "+idCollar));
	}

	public void createShop(String name, int storageCapacity) {
		Store store = new Store(name, storageCapacity);
		storeRepository.save(store);
	}
	

}
