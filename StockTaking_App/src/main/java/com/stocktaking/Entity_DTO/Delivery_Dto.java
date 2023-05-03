package com.stocktaking.Entity_DTO;

import java.sql.Date;

import com.stocktaking.EntityBBDD.T_Delivery;
import com.stocktaking.Mapper.MapperInterface;

public class Delivery_Dto implements MapperInterface<T_Delivery>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private Date date;
	
	/*
		Zona de Constructores
	*/
	public Delivery_Dto() 
	{

	}
	
	public Delivery_Dto(T_Delivery entity) 
	{
		this.mapper(entity);
	}
	
	public Delivery_Dto(Long id, Date date) 
	{
		this.id = id;
		this.date = date;
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

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Delivery entity) 
	{
		try 
		{
			this.id = entity.getId();
			this.date = entity.getDate();
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	
}
