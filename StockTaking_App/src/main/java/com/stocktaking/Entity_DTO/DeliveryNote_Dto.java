package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_DeliveryNote;
import com.stocktaking.Mapper.MapperInterface;

public class DeliveryNote_Dto implements MapperInterface<T_DeliveryNote> 
{
	/*
		Zona de Atributos
	*/
	private Long deliveryId;
	private Long productId;
	private Long supplierId;
	private Integer quantity;

	/*
		Zona de Constructores
	*/
	public DeliveryNote_Dto(T_DeliveryNote entity) 
	{
		this.mapper(entity);
	}
	
	public DeliveryNote_Dto() 
	{
	}
	
	public DeliveryNote_Dto
	(
		Long deliveryId, 
		Long productId, 
		Long supplierId, 
		Integer quantity
	) 
	{
		this.deliveryId = deliveryId;
		this.productId = productId;
		this.supplierId = supplierId;
		this.quantity = quantity;
	}

	/*
		Zona de Getters & Setters
	*/
	public Long getDeliveryId() 
	{
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) 
	{
		this.deliveryId = deliveryId;
	}

	public Long getProductId() 
	{
		return productId;
	}

	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getSupplierId() 
	{
		return supplierId;
	}

	public void setSupplierId(Long supplierId) 
	{
		this.supplierId = supplierId;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_DeliveryNote entity) {
		try 
		{
			this.deliveryId = entity.getId().getDeliveryId();
			this.productId = entity.getId().getProductId();
			this.supplierId = entity.getId().getSupplierId();
			this.quantity = entity.getQuantity();
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	
}
