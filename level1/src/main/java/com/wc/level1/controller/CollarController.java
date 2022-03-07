package com.wc.level1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wc.level1.entity.Store;
import com.wc.level1.repository.CollarRepository;
import com.wc.level1.service.CollarService;
import com.wc.level1.service.StoreService;


@RestController
@RequestMapping("/pictures")
public class CollarController {
	
	@Autowired
	CollarService collarService;
	
	@Autowired
	StoreService storeService;
	
	public CollarController(CollarService collarService){
		this.collarService = collarService;
	}
	
	@PostMapping("/shops/{idStore}/pictures")
	public void addCollar(
			@PathVariable("idStore") Long idStore,
			@RequestParam(name="author") String author,
			@RequestParam(name="name") String name,
			@RequestParam(name="price") double price) {
		Store store = storeService.getOneStore(idStore);
		collarService.saveCollar(author, name, price, store);
	}
	
	@DeleteMapping("/shops/{idStore}/pictures")
	public void deleteCollars(
			@PathVariable("idStore") Long idStore) {
		collarService.deleteCollars(idStore);
	}
	
	
	
}
