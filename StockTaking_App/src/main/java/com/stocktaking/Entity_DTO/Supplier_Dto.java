package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Supplier;
import com.stocktaking.Mapper.MapperInterface;

public class Supplier_Dto implements MapperInterface<T_Supplier>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String email;
	private String address;
	private String description;
	
	/*
		Zona de Constructores
	*/
	public Supplier_Dto() 
	{

	}
	
	public Supplier_Dto(Long id, String name, String email, String address, String description) 
	{

		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.description = description;
	}
	
	public Supplier_Dto(T_Supplier entity) 
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

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
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
	public boolean mapper(T_Supplier entity) 
	{
		try
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.email = entity.getName();
			this.address = entity.getAddress();
			this.description = entity.getDescription();
		}
		catch (Exception e)
		{
			
		}
		return false;
	}
	
	
}
