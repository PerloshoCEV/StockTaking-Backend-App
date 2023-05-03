package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Attribute;
import com.stocktaking.Enum.Type_TypeValue;
import com.stocktaking.Mapper.MapperInterface;

public class Attribute_Dto implements MapperInterface<T_Attribute>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String description;
	private Type_TypeValue valueType;
	
	/*
		Zona de Constructores
	*/
	public Attribute_Dto() 
	{
	}
	
	public Attribute_Dto(Long id, String name, String description, Type_TypeValue valueType) 
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.valueType = valueType;
	}
	
	public Attribute_Dto(T_Attribute entity) 
	{
		this.mapper(entity);
	}
	
	/*
		Zona de Getters & Setters
	*/
	
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public Type_TypeValue getValueType() 
	{
		return valueType;
	}

	public void setValueType(Type_TypeValue valueType) 
	{
		this.valueType = valueType;
	}

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Attribute entity) 
	{
		try 
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.description = entity.getDescription();
			this.valueType = entity.getValueType();
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	
}
