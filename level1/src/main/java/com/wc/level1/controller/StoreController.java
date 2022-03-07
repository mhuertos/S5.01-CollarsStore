package com.wc.level1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wc.level1.entity.Store;
import com.wc.level1.service.StoreService;

@RestController
@RequestMapping("/shops")
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@GetMapping("shops")
	public List<Store> getStores(){
		return storeService.getStores();
	}
	
	@PostMapping("shops")
	public void createShop(
			@RequestParam(name = "storeName", required=true) String name,
			@RequestParam(name = "storageCapacity", required=true) int storageCapacity) {
		storeService.createShop(name, storageCapacity);
	}

}
