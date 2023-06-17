package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_TypeAttribute;
import com.stocktaking.Mapper.MapperInterface;

public class TypeAttribute_Dto implements MapperInterface<T_TypeAttribute>
{
	/*
		Zona de Atributos
	*/
	private Long typeId;
	private String typeName = "";
	private Long attributeId;
	private String attributeName = "";
	
	/*
		Zona de Constructores
	*/
	public TypeAttribute_Dto() 
	{
	}
	
	public TypeAttribute_Dto(T_TypeAttribute entity) 
	{
		this.mapper(entity);
	}
	
	public TypeAttribute_Dto
	(
		Long typeId, 
		Long attributeId
	) 
	{
		this.typeId = typeId;
		this.attributeId = attributeId;
	}

	/*
		Zona de Getters & Setters
	*/
	public Long getTypeId() 
	{
		return typeId;
	}

	public void setTypeId(Long typeId) 
	{
		this.typeId = typeId;
	}

	public Long getAttributeId() 
	{
		return attributeId;
	}

	public void setAttributeId(Long attributeId) 
	{
		this.attributeId = attributeId;
	}

	
	
	public String getTypeName() 
	{
		return typeName;
	}

	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getAttributeName() 
	{
		return attributeName;
	}

	public void setAttributeName(String attributeName) 
	{
		this.attributeName = attributeName;
	}

	public void setAll(Long attributeId, String attributeName, Long typeId, String typeName) 
	{
		this.attributeId = attributeId;
		this.attributeName = attributeName;
		this.typeId = typeId;
		this.typeName = typeName;
	}
	

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_TypeAttribute entity) 
	{
		try 
		{
			this.typeId = entity.getId().getTypeId();
			this.typeName = entity.getType().getName();
			this.attributeId = entity.getId().getAttributeId();
			this.attributeName = entity.getAttribute().getName();
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	
}
