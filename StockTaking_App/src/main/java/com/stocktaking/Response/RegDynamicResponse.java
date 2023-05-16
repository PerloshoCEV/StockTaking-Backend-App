package com.stocktaking.Response;

import java.util.List;

public class RegDynamicResponse 
{
	/*
		Variables
	*/
	private Long idProduct;
	private List<AttributeValueResponse> attributeValue = null;
	
	/*
		Constructores
	*/
	public RegDynamicResponse() 
	{
	}
	
	public RegDynamicResponse
	(
		Long idProduct, 
		List<AttributeValueResponse> attributeValue
	) 
	{
		this.idProduct = idProduct;
		this.attributeValue = attributeValue;
	}

	/*
		Getters & Setters
	*/
	public Long getIdProduct() 
	{
		return idProduct;
	}

	public void setIdProduct(Long idProduct) 
	{
		this.idProduct = idProduct;
	}

	public List<AttributeValueResponse> getAttributeValue() 
	{
		return attributeValue;
	}

	public void setAttributeValue(List<AttributeValueResponse> attributeValue) 
	{
		this.attributeValue = attributeValue;
	}
}
