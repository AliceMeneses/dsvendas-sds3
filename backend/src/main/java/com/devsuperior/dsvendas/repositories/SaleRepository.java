package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(sale.seller, SUM(sale.amount)) "
			+ "FROM Sale sale GROUP BY sale.seller ")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(sale.seller, SUM(sale.visited), SUM(sale.deals)) "
			+ "FROM Sale sale GROUP BY sale.seller ")
	List<SaleSuccessDTO> successGroupedBySeller();
}
