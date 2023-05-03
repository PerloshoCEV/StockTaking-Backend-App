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
@Table(name = "T_Bill")
public class T_Bill 
{
	/*
		Zona de Atributos
	*/
	@EmbeddedId
	private EmbKey_Bill id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("saleId")
	private T_Sale sale;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private T_Product product;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("clientId")
	private T_Client client;
	
	@Column(name = "Quantity")
	private Integer quantity;

	/*
		Zona de Constructores
	*/
	public T_Bill() 
	{
		super();
	}
	
	public T_Bill
	(
		EmbKey_Bill id, 
		T_Sale sale, 
		T_Product product, 
		T_Client client, 
		Integer quantity
	) 
	{
		super();
		this.id = id;
		this.sale = sale;
		this.product = product;
		this.client = client;
		this.quantity = quantity;
	}

	/*
		Zona de Métodos Getters / Setters
	*/
	public EmbKey_Bill getId() 
	{
		return id;
	}

	public void setId(EmbKey_Bill id) 
	{
		this.id = id;
	}

	public T_Sale getSale() 
	{
		return sale;
	}

	public void setSale(T_Sale sale) 
	{
		this.sale = sale;
	}

	public T_Product getProduct() 
	{
		return product;
	}

	public void setProduct(T_Product product) 
	{
		this.product = product;
	}

	public T_Client getClient() 
	{
		return client;
	}

	public void setClient(T_Client client) 
	{
		this.client = client;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}
}
