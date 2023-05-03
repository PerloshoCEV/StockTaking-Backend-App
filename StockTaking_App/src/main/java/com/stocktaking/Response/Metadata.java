package com.stocktaking.Response;

public class Metadata 
{
	/*
		Variables
	*/
	private Pagination pagination;
	
	/*
		Constructores
	*/
	public Metadata() 
	{
	}
	public Metadata(Pagination pag) 
	{
		pagination = pag;
	}

	/*
		Getters & Setters
	*/
	public Pagination getPagination() 
	{
		return pagination;
	}

	public void setPagination(Pagination pagination) 
	{
		this.pagination = pagination;
	}
}
