package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Type;
import com.stocktaking.Mapper.MapperInterface;

public class Type_Dto implements MapperInterface<T_Type>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String description;
	
	/*
		Zona de Constructores
	*/
	public Type_Dto() 
	{
	}
	
	public Type_Dto(Long id, String name, String description) 
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Type_Dto(T_Type entity) 
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

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Type entity) 
	{
		try
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.description = entity.getDescription();
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	
	
}
