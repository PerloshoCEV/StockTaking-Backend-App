package com.stocktaking.ApiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.DeliveryNote_Repository;
import com.stocktaking.Entity_DTO.DeliveryNote_Dto;

@Service
public class DeliveryNote_Service 
{


	@Autowired
	DeliveryNote_Repository repositorySql;

	/*
		Método CreateService.
	*/
	public DeliveryNote_Dto createService(Long deliveryId, Long productId, Long supplierId, Integer quantity) 
	{
		DeliveryNote_Dto DeliveryNoteToSave = null;
		try
		{
			DeliveryNoteToSave = repositorySql.create(deliveryId,productId, supplierId, quantity);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return DeliveryNoteToSave;
	}


	/*
	Método deleteId.
	*/
	public DeliveryNote_Dto deleteId(DeliveryNote_Dto deleteEntity) 
	{
		return repositorySql.delete(deleteEntity.getDeliveryId(), deleteEntity.getProductId(),deleteEntity.getSupplierId(),deleteEntity.getQuantity());
	}
	
	/*
	Método findByProductId.
	*/
	
	public List<DeliveryNote_Dto> readByProductId(DeliveryNote_Dto id) 
	{
		return repositorySql.findByProductId(id.getProductId());
	}
	
	/*
	Método findBySupplierId.
	*/
	
	public List<DeliveryNote_Dto> findBySupplierId(DeliveryNote_Dto id) 
	{
		return repositorySql.findBySupplierId(id.getSupplierId());
	}
	
	/*
	Método findByDeliveryId.
	*/
	
	public List<DeliveryNote_Dto> findByDeliveryId(DeliveryNote_Dto id) 
	{
		return repositorySql.findByDeliveryId(id.getDeliveryId());
	}
	
	/*
	Aumentar, disminuir una unidad en value.
	*/


}
