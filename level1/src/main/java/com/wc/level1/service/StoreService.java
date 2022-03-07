package com.wc.level1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.level1.entity.Store;
import com.wc.level1.repository.CollarRepository;
import com.wc.level1.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	CollarRepository collarRepository;
	
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}
	

	public void createShop(String storeName, int storageCapacity) {
		Store store = new Store(storeName, storageCapacity);
		storeRepository.save(store);
	}
	
	public Store getOneStore(Long idStore) {
		Store store = storeRepository.findById(idStore).orElseThrow(
				() -> new IllegalStateException("Doesn't exists any store with id: "+idStore));
		return store;
	}

	public List<Store> getStores() {
		return storeRepository.findAll();
	}

	public Store returnOnlyOneStore(long idStore) {
		Store store = storeRepository.findById(idStore)
				.orElseThrow(() -> new IllegalStateException("It doesn't exists any store with "+idStore+" id."));
		return store;
	}


}
