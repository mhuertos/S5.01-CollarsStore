package com.level1_v2.level1_version2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.level1_v2.level1_version2.entity.Collar;
import com.level1_v2.level1_version2.entity.Store;
import com.level1_v2.level1_version2.service.CollarService;
import com.level1_v2.level1_version2.service.StoreService;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	CollarService collarService;
	
	@Autowired
	StoreService storeService;
	
	public Controller(CollarService collarService, StoreService storeService) {
		this.collarService = collarService;
		this.storeService = storeService;
	}
	
	@GetMapping("shops")
	public List<Store> showStores() {
		return storeService.showStores();
	}
	
	@PostMapping("shops")
	public void createShop(
			@RequestParam(name = "storeName", required=true) String name,
			@RequestParam(name = "storageCapacity", required=true) int storageCapacity) {
		storeService.createShop(name, storageCapacity);
	}
	
	@PostMapping("shops/{idShop}/pictures")
	public void addCollar(
			@PathVariable("idShop") Long idCollar,
			@RequestParam(name="author") String author,
			@RequestParam(name="name") String name,
			@RequestParam(name="price") double price){
		
		Store store = storeService.getOneStore(idCollar);
		collarService.saveCollar(author, name, price, store);
	}
	
	@GetMapping("shops/{idShop}/pictures")
	public List<Collar> showCollar(
			@PathVariable(name="idShop") Long idStore){
		Store store = storeService.getOneStore(idStore);
		return collarService.showCollars(store);
		//return collarService.showCollarsByFields(store); Prova
	}
	
	@DeleteMapping("shops/{idStore}/pictures")
	public void deleteCollars(
			@PathVariable("idStore") Long idStore) {
		Store store = storeService.getOneStore(idStore);
		collarService.deleteCollars(store);
	}

}
