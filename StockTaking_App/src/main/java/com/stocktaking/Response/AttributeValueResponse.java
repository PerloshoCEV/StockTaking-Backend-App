package com.stocktaking.Response;

public class AttributeValueResponse 
{
	/*
		Variables
	*/
	private Long idAttribute = null;
	private String nameAttribute;
	private String valueAttribute;
	
	/*
		Constructores
	*/
	public AttributeValueResponse() 
	{
	}
	
	// Constructor sin id de atributo (Para los atributos base de productos)
	public AttributeValueResponse
	( 
		String nameAttribute, 
		String valueAttribute
	) 
	{
		this.nameAttribute = nameAttribute;
		this.valueAttribute = valueAttribute;
	}
	
	// Constructor con id de atributo (para los atributos extras)
	public AttributeValueResponse
	(
		Long idAttribute, 
		String nameAttribute, 
		String valueAttribute
	) 
	{
		this.idAttribute = idAttribute;
		this.nameAttribute = nameAttribute;
		this.valueAttribute = valueAttribute;
	}

	/*
		Getters & Setters
	*/
	public Long getIdAttribute() 
	{
		return idAttribute;
	}

	public void setIdAttribute(Long idAttribute) 
	{
		this.idAttribute = idAttribute;
	}

	public String getNameAttribute() 
	{
		return nameAttribute;
	}

	public void setNameAttribute(String nameAttribute) 
	{
		this.nameAttribute = nameAttribute;
	}

	public String getValueAttribute() 
	{
		return valueAttribute;
	}

	public void setValueAttribute(String valueAttribute) 
	{
		this.valueAttribute = valueAttribute;
	}
}
