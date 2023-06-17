package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_ProductAttribute;
import com.stocktaking.Mapper.MapperInterface;

public class ProductAttribute_Dto implements MapperInterface<T_ProductAttribute>
{
	/*
		Zona de Atributos
	*/
	private Long productId;
	private Long attributeId;
	private String attributeName;
	private String value;
	
	/*
		Zona de Constructores
	*/
	public ProductAttribute_Dto() 
	{
	}
	
	public ProductAttribute_Dto(T_ProductAttribute entity) 
	{
		this.mapper(entity);
	}
	
	public ProductAttribute_Dto
	(
		Long productId,
		Long attributeId, 
		String attributeName,
		String value
	) 
	{
		this.productId = productId;
		this.attributeId = attributeId;
		this.attributeName = attributeName;
		this.value = value;
	}

	/*
		Zona de Getters & Setters
	*/
	public Long getProductId() 
	{
		return productId;
	}

	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getAttributeId() 
	{
		return attributeId;
	}

	public void setAttributeId(Long attributeId) 
	{
		this.attributeId = attributeId;
	}

	public String getValue() 
	{
		return value;
	}

	public void setValue(String value) 
	{
		this.value = value;
	}
	
	public String getAttributeName() 
	{
		return attributeName;
	}

	public void setAttributeName(String attributeName) 
	{
		this.attributeName = attributeName;
	}

	public void setAll(Long productId, Long attributeId, String attributeName, String value) 
	{
		this.productId = productId;
		this.attributeId = attributeId;
		this.attributeName = attributeName;
		this.value = value;
	}
	

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_ProductAttribute entity) 
	{
		try 
		{
			this.productId = entity.getId().getProductId();
			this.attributeId = entity.getId().getAttributeId();
			this.attributeName = entity.getAttribute().getName();
			this.value = entity.getValueAttr();
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	
}
