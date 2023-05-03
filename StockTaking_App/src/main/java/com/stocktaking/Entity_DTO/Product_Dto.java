package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Product;
import com.stocktaking.EntityBBDD.T_Type;
import com.stocktaking.Mapper.MapperInterface;

public class Product_Dto implements MapperInterface<T_Product>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String description;
	private Integer stock;
	private T_Type type;
	
	/*
		Zona de Constructores
	*/
	public Product_Dto() 
	{

	}
	
	public Product_Dto(Long id, String name, String description, Integer stock, T_Type type) 
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.type = type;
	}
	
	public Product_Dto(T_Product entity) 
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

	public String getName() {
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

	public Integer getStock() 
	{
		return stock;
	}

	public void setStock(Integer stock) 
	{
		this.stock = stock;
	}

	public T_Type getType() 
	{
		return type;
	}

	public void setType(T_Type type) 
	{
		this.type = type;
	}

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Product entity) 
	{
		try
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.description = entity.getDescription();
			this.stock = entity.getStock();
			this.type = entity.getType();
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	
	
}
