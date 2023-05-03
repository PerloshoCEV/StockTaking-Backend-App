package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Bill;
import com.stocktaking.Mapper.MapperInterface;

public class Bill_Dto implements MapperInterface<T_Bill>
{
	/*
		Zona de Atributos
	*/
	private Long saleId;
	private Long productId;
	private Long clientId;
	
	private Integer quantity;

	/*
		Zona de Constructores
	*/
	public Bill_Dto() 
	{	
	}
	
	public Bill_Dto(T_Bill entity) 
	{
		this.mapper(entity);
	}
	
	public Bill_Dto
	(
		Long saleId, 
		Long productId, 
		Long clientId, 
		Integer quantity
	) 
	{
		this.saleId = saleId;
		this.productId = productId;
		this.clientId = clientId;
		this.quantity = quantity;
	}
	
	/*
		Zona de Getters & Setters
	*/
	public Long getSaleId() 
	{
		return saleId;
	}

	public void setSaleId(Long saleId) 
	{
		this.saleId = saleId;
	}

	public Long getProductId() 
	{
		return productId;
	}

	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getClientId() 
	{
		return clientId;
	}

	public void setClientId(Long clientId) 
	{
		this.clientId = clientId;
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
	public boolean mapper(T_Bill entity) 
	{
		try 
		{
			this.saleId = entity.getId().getSaleId();
			this.productId = entity.getId().getProductId();
			this.clientId = entity.getId().getClientId();
			this.quantity = entity.getQuantity();
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	
}
