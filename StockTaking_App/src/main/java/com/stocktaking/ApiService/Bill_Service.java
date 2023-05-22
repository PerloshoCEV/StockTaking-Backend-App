package com.stocktaking.ApiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Bill_Repository;
import com.stocktaking.Entity_DTO.Bill_Dto;
import com.stocktaking.Entity_DTO.TypeAttribute_Dto;

@Service
public class Bill_Service 
{
	
	@Autowired
	Bill_Repository repositorySql;
	
	/*
		Método CreateService.
	*/

	public Bill_Dto createService(Long saleId, Long productId, Long clientId, Integer quantity) 
	{
		Bill_Dto BillToSave = null;
		try
		{
			BillToSave = repositorySql.create(saleId, productId, clientId, quantity);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return BillToSave;
	}


	/*
	Método deleteId.
	*/
	public Bill_Dto deleteId(Bill_Dto deleteEntity) 
	{
		return repositorySql.delete(deleteEntity.getSaleId(), deleteEntity.getProductId(), deleteEntity.getClientId(), deleteEntity.getQuantity());
	}
	
	/*
	Método findBySaleId.
	*/
	
	public List<Bill_Dto> findBySaleId(Long id) 
	{
		return repositorySql.findBySaleId(id);
	}
	
	/*
	Método findByProductId.	
	*/
	
	public List<Bill_Dto> findByProductId(Long id) 
	{
		return repositorySql.findByProductId(id);
	}
	
	/*
	Método findByClientId.
	*/
	
	public List<Bill_Dto> findByClientId(Long id) 
	{
		return repositorySql.findByClientId(id);
	}
	
	public List<Bill_Dto> findOne(Long saleId, Long productId, Long clientId, Integer quantity) 
	{
		return repositorySql.findOne(saleId, productId, clientId, quantity);
	}
	
	public List<Bill_Dto> findAll() 
	{
		return repositorySql.findAll();
	}
	

}
