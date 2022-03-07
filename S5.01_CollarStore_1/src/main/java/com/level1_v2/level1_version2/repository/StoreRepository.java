package com.level1_v2.level1_version2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.level1_v2.level1_version2.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
