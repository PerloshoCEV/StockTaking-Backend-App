package com.stocktaking.Entity_DTO;

import java.sql.Date;

import com.stocktaking.EntityBBDD.T_Sale;
import com.stocktaking.Mapper.MapperInterface;

public class Sale_Dto implements MapperInterface<T_Sale>
{
	private Long id;
	private Date date;
	
	public Sale_Dto() 
	{
	}
	
	public Sale_Dto(T_Sale entity) 
	{
		this.mapper(entity);
	}
	
	public Sale_Dto(Long id, Date date) 
	{
		this.id = id;
		this.date = date;
	}

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

	@Override
	public boolean mapper(T_Sale entity) 
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
