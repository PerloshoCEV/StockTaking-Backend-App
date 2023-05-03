package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Client;
import com.stocktaking.Mapper.MapperInterface;

public class Client_Dto implements MapperInterface<T_Client>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String lastName;
	private String secondLastName;
	private String age;
	
	/*
		Zona de Constructores
	*/
	public Client_Dto() 
	{
	}
	
	public Client_Dto(Long id, String name, String lastName, String secondLastName, String age) 
	{
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.age = age;
	}
	
	public Client_Dto(T_Client entity) 
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

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getSecondLastName() 
	{
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) 
	{
		this.secondLastName = secondLastName;
	}

	public String getAge() 
	{
		return age;
	}

	public void setAge(String age) 
	{
		this.age = age;
	}

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Client entity) 
	{
		try
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.lastName = entity.getLastName();
			this.secondLastName = entity.getSecondLastName();
			this.age = entity.getAge();
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	
	
}
