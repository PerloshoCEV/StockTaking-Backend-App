package com.stocktaking.EntityBBDD;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Product_Attribute")
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
	
	@Column(name = "ValueAttr")
	private String valueAttr;

	/*
		Zona de Constructores
	*/
	public T_ProductAttribute() 
	{
		super();

	}
	
	public T_ProductAttribute(T_Product product, T_Attribute attribute, String valueAttr) 
	{
		super();
		this.product = product;
		this.attribute = attribute;
		this.valueAttr = valueAttr;
	}
	
	public T_ProductAttribute
	(
		EmbKey_ProductAttribute id, 
		T_Product product, 
		T_Attribute attribute, 
		String valueAttr
	) 
	{
		super();
		this.id = id;
		this.product = product;
		this.attribute = attribute;
		this.valueAttr = valueAttr;
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

	public String getValueAttr() 
	{
		return valueAttr;
	}

	public void setValueAttr(String valueAttr) 
	{
		this.valueAttr = valueAttr;
	}
}
