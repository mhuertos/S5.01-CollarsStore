package com.wc.level1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wc.level1.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
