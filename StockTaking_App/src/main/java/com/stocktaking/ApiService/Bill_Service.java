package com.stocktaking.ApiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Bill_Repository;
import com.stocktaking.Entity_DTO.Bill_Dto;

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
	
	public List<Bill_Dto> readBySaleId(Bill_Dto id) 
	{
		return repositorySql.findBySaleId(id.getSaleId());
	}
	
	/*
	Método findByProductId.	
	*/
	
	public List<Bill_Dto> readByProductId(Bill_Dto id) 
	{
		return repositorySql.findByProductId(id.getProductId());
	}
	
	/*
	Método findByClientId.
	*/
	
	public List<Bill_Dto> readByClientId(Bill_Dto id) 
	{
		return repositorySql.findByClientId(id.getClientId());
	}
	

}
