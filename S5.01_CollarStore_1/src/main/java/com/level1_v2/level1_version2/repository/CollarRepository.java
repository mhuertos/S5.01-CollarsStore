package com.level1_v2.level1_version2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.level1_v2.level1_version2.entity.Collar;
import com.level1_v2.level1_version2.entity.Store;

@Repository
public interface CollarRepository extends JpaRepository<Collar, Long> {
	
	List<Collar> findByStore(Store store);

	void deleteByStore(Store store);
	
	int countByStore(Store store);
	
	/*No funciona
	La meva inteció seria poder recuperar el llistat de quadres sense l'atribut 'Store'.
	associat pel 'OneToMany a la taula collar.*/
	List<Collar> findAuthorAndNameAndPriceByStore(Store store);
	
	

}
