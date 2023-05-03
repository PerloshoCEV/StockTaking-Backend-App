package com.stocktaking.EntityBBDD;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_TypeAttribute")
public class T_TypeAttribute 
{
	/*
		Zona de Atributos
	*/
	@EmbeddedId
	private EmbKey_TypeAttribute id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("typeId")
	private T_Type type;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("attributeId")
	private T_Attribute attribute;
	
	/*
		Zona de Constructores
	*/
	public T_TypeAttribute() 
	{
		super();
	}
	
	public T_TypeAttribute(T_Type type, T_Attribute attribute) 
	{
		super();
		this.type = type;
		this.attribute = attribute;
	}
	
	public T_TypeAttribute(EmbKey_TypeAttribute id, T_Type type, T_Attribute attribute) 
	{
		super();
		this.id = id;
		this.type = type;
		this.attribute = attribute;
	}
	
	/*
		Zona de Getters & Setters
	*/
	public EmbKey_TypeAttribute getId() 
	{
		return id;
	}
	
	public void setId(EmbKey_TypeAttribute id) 
	{
		this.id = id;
	}
	
	public T_Type getType() 
	{
		return type;
	}
	
	public void setType(T_Type type) 
	{
		this.type = type;
	}
	
	public T_Attribute getAttribute() 
	{
		return attribute;
	}
	
	public void setAttribute(T_Attribute attribute) 
	{
		this.attribute = attribute;
	}
}
