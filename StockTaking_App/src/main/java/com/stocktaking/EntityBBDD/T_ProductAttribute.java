package com.stocktaking.EntityBBDD;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

public class T_ProductAttribute 
{
	/*
		Zona de Atributos
	*/
	@EmbeddedId
	private EmbKey_ProductAttribute id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private T_Product product;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("attributeId")
	private T_Attribute attribute;
	
	@Column(name = "Value")
	private String value;

	/*
		Zona de Constructores
	*/
	public T_ProductAttribute() 
	{
		super();

	}
	
	public T_ProductAttribute(T_Product product, T_Attribute attribute, String value) 
	{
		super();
		this.product = product;
		this.attribute = attribute;
		this.value = value;
	}
	
	public T_ProductAttribute(EmbKey_ProductAttribute id, T_Product product, T_Attribute attribute, String value) 
	{
		super();
		this.id = id;
		this.product = product;
		this.attribute = attribute;
		this.value = value;
	}

	/*
		Zona de Getters & Setters
	*/
	public EmbKey_ProductAttribute getId() 
	{
		return id;
	}

	public void setId(EmbKey_ProductAttribute id) 
	{
		this.id = id;
	}

	public T_Product getProduct() 
	{
		return product;
	}

	public void setProduct(T_Product product) 
	{
		this.product = product;
	}

	public T_Attribute getAttribute() 
	{
		return attribute;
	}

	public void setAttribute(T_Attribute attribute) 
	{
		this.attribute = attribute;
	}

	public String getValue() 
	{
		return value;
	}

	public void setValue(String value) 
	{
		this.value = value;
	}
}
